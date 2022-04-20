package com.ecommerce.repositories;

import com.ecommerce.repositories.entites.CodeEntity;

public interface CodeRepo extends Repository<CodeEntity,Integer> {
    CodeEntity findByCode(String code);
}
