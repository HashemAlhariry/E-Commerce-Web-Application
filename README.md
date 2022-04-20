![logo](https://user-images.githubusercontent.com/36333141/164304926-ff40e561-0867-436d-be92-58c823e5174e.jpeg)
>An e-commerce website built using JSP and Servlets a responsive web design that will be automatically adjusted for different screen sizes.
# 🏛 Architecture
This software project was built using a layered architecture. The following diagram demonstrates an example use case that goes through all the layers. 

![image](https://user-images.githubusercontent.com/73137611/155808282-0a0ee1ab-9d35-4258-a953-c9ccad72f707.png)

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

![Animation](https://user-images.githubusercontent.com/73137611/155806535-92e5a736-0b30-4e19-b5f1-371c91970736.gif)
![Animation2](https://user-images.githubusercontent.com/73137611/155806878-b4b497cd-5821-4420-9a9d-e95340aa4ff2.gif)

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
* [Ahmed Ashraf](https://github.com/ahmedashrfhassan)
* [Ahmed Osama](https://github.com/AhmedOsama123)
* [Hashem Alhariry](https://github.com/HashemAlhariry)
* [Marwa Adel](https://github.com/marwaadel12)
