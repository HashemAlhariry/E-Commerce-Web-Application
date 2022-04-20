package com.ecommerce.services.impls;

import com.ecommerce.exceptions.FoundBeforeException;
import com.ecommerce.exceptions.NotFoundException;
import com.ecommerce.presentation.beans.SignUpBean;
import com.ecommerce.presentation.beans.UserBean;
import com.ecommerce.presentation.beans.UserViewBean;
import com.ecommerce.repositories.CodeRepo;
import com.ecommerce.repositories.UserRepository;
import com.ecommerce.repositories.entites.CodeEntity;
import com.ecommerce.repositories.entites.CodeState;
import com.ecommerce.repositories.entites.UserEntity;
import com.ecommerce.repositories.entites.UserState;
import com.ecommerce.repositories.impl.CodeRepoImpl;
import com.ecommerce.repositories.impl.UserRepositoryImpl;
import com.ecommerce.services.UserService;
import com.ecommerce.utils.MailUtil;
import com.ecommerce.utils.mappers.UserMapper;
import org.apache.commons.mail.EmailException;

import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private CodeRepo codeRepo;

    public UserServiceImpl(String reqId) {
        userRepository = new UserRepositoryImpl(reqId);
        codeRepo = new CodeRepoImpl(reqId);
    }

    @Override
    public List<UserViewBean> viewAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return UserMapper.INSTANCE.userEntitiesToViewUserBeans(userEntities);
    }

    @Override
    public List<UserViewBean> viewUserByEmail(String email) {
        List<UserEntity> userEntities = userRepository.getUserByEmail(email);
        return UserMapper.INSTANCE.userEntitiesToViewUserBeans(userEntities);
    }

    @Override
    public boolean registerUser(SignUpBean signUpBean, String domain) throws FoundBeforeException, MalformedURLException, EmailException {
        UserEntity user = UserMapper.INSTANCE.userRegBeanToEntity(signUpBean);
        String email = user.getEmail();
        if (userRepository.findByEmail(email) == null) {
            user.setState(UserState.IN_ACTIVE);
            user = userRepository.saveUser(user);
            String code = UUID.randomUUID().toString();
            MailUtil.getInstance().sendConfirmationMail(domain + "/confirmreg", user.getEmail(), code);
            CodeEntity codeEntity = new CodeEntity(CodeState.CONFIRM_REGISTER, code, user);
            codeRepo.save(codeEntity);
            return true;
        } else {
            throw new FoundBeforeException("this email found before");
        }
    }

    @Override
    public boolean confirmRegister(String code) throws NotFoundException {
        CodeEntity codeEntity = codeRepo.findByCode(code);
        if (codeEntity != null) {
            codeEntity.getUser().setState(UserState.ACTIVE);
            userRepository.updateUser(codeEntity.getUser());
            codeRepo.delete(codeEntity);
            return true;
        } else {
            throw new NotFoundException("code not found");
        }
    }

    @Override
    public boolean checkUserEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity != null;
    }

    @Override
    public UserBean getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity != null){
            return UserMapper.INSTANCE.userEntityToUserBean(userEntity);
        }
        return null;
    }
}
