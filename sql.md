### Create `user_accounts` table

```
CREATE TABLE user_accounts (
    id INT NOT NULL AUTO_INCREMENT, 
    email VARCHAR(255) UNIQUE, 
    password VARCHAR(255), 
    name VARCHAR(255), 
    PRIMARY KEY (id));
```

### Create `blogs` table 

```
CREATE TABLE blogs (id INT NOT NULL AUTO_INCREMENT,
            title VARCHAR(255),
            image VARCHAR(255), 
            name VARCHAR(255),
            description LONGTEXT,
            PRIMARY KEY (id));
```