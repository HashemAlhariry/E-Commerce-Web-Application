![logo](https://user-images.githubusercontent.com/36333141/164304926-ff40e561-0867-436d-be92-58c823e5174e.jpeg)
>An e-commerce website built using JSP and Servlets a responsive web design that will be automatically adjusted for different screen sizes.
# 🏛 Architecture
This software project was built using a layered architecture. The following diagram demonstrates an example use case that goes through all the layers. 
![layer](https://user-images.githubusercontent.com/36333141/164351708-f3be4a50-4d52-42b0-b651-b746a1393a06.png)


# 🏭 Sequence
![sequance1](https://user-images.githubusercontent.com/36333141/164316416-9f5f92ff-b594-4465-90be-9c82ae7ecfd3.png) ![sequance2](https://user-images.githubusercontent.com/36333141/164319528-1aa9ad58-89ce-4e51-bb96-5239117512fc.png)



# ⚙ Features
* Registration and login
* Chat bot and chat with admin
* View products
* Filter products viewing by name nad category
* Updating user profiles
* Add to cart
* Add to wish list
* Purchase products via stripe 
* Admin dash board
* Admin CRUD operations to products

# 💁 Client
![ezgif com-gif-maker](https://user-images.githubusercontent.com/45319166/164311567-bac9b6e3-a82f-4a41-9ead-8f494e819d94.gif)
# 🔑 Admin
![ezgif com-gif-maker-2](https://user-images.githubusercontent.com/45319166/164312129-3e00d0c0-5316-4529-9d9a-794ad21112cc.gif)


# ⚙ Technologies used
* Maven
* ORM
* Servlets
* Jsp
* Docker
* Apache mail
* Bean Validation (Hibernate Validator)
* MapStruct
* Logback
* Lombok
* MySQL
* Stripe

# 🛠 How to run
**Docker**
* Go to the project root folder
* Packge the project using this command:
```maven
mvn clean package
``` 
* To create an image from docker file write this command:
```docker
docker image build -t amazonya .
```
* To run the project write the the following commands:
```docker
docker network create amazonya_network
docker run --name amazonya_db --network amazonya_network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=amazonya -d mysql:8.0.28
docker container run --name amzonya_server --network amazonya_network -p 80:8080 -d amazonya
```

# 👷🏽 Contributors
* [Abdelrahman Khattab](https://github.com/abdelrahman-khattab)
* [Marwa Abdul-karim](https://github.com/marwaadel12)
* [Ahmed Ashraf](https://github.com/ahmedashrfhassan)
* [Ahmed Osama](https://github.com/AhmedOsama123)
* [Hashem Alhariry](https://github.com/HashemAlhariry)

