# Sample E-commerce MSA

## Services

### **Order Service**

| Method | Endpoint           | Purpose            |
| ------ | ------------------ | ------------------ |
| POST   | `/api/orders`      | Create a new order |
| GET    | `/api/orders/{id}` | Fetch order by ID  |

### **Inventory Service**

| Method | Endpoint                 | Purpose                        |
| ------ | ------------------------ | ------------------------------ |
| POST   | `/api/inventory`         | Create inventory for a product |
| POST   | `/api/inventory/reserve` | Reserve stock for a product    |

### **UserProfile Service**

| Method | Endpoint                | Purpose                        |
| ------ | ----------------------- | ------------------------------ |
| POST   | `/api/users`            | Create a new user profile      |
| GET    | `/api/users/{username}` | Fetch user profile by username |

Create new user

```bash
curl --location 'http://localhost:8200/api/users' \
--header 'Content-Type: application/json' \
--data '{
    "username":"ashish",
    "email":"ashish.s",
    "role":"ADMIN",
    "password": "password"
}'
```

### **Authentication Service**

| Method | Endpoint          | Purpose                         |
| ------ | ----------------- | ------------------------------- |
| POST   | `/api/auth/login` | Authenticate user and issue JWT |

**Internal Endpoint**

| Method | Endpoint                | Purpose                       |
| ------ | ----------------------- | ----------------------------- |
| POST   | `/internal/credentials` | Create credentials for a user |

User login

```bash
curl --location 'http://localhost:8300/api/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username":"",
    "password": ""
}'
```

### **Discovery Service**

| Method | Endpoint       | Purpose                  |
| ------ | -------------- | ------------------------ |
| GET    | `/`            | Eureka dashboard         |
| GET    | `/eureka/apps` | Registry of all services |

### **Gateway Service**                               |

### **Config Service**

| Method | Endpoint                           | Purpose                               |
| ------ | ---------------------------------- | ------------------------------------- |
| GET    | `/{application}/{profile}`         | Fetch merged config                   |
| GET    | `/{application}/{profile}/{label}` | Fetch config from specific Git branch |

## User Profile and Credential Creation (Sync)

- **User profile owns user identity**
- **Auth service owns user credentials**
- **User profile orchastrates user onboarding**


```text
Client -> UserProfile [Create Profile, call auth service] -> Auth Service [Create credentials]
```
