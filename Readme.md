# Sample E-commerce MSA

## Services

### **Order Service**

### **Inventory Service**

### **UserProfile Service**

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

### **Gateway Service**

### **Config Service**

## User Profile and Credential Creation (Sync)

- **User profile owns user identity**
- **Auth service owns user credentials**
- **User profile orchastrates user onboarding**


```text
Client -> UserProfile [Create Profile, call auth service] -> Auth Service [Create credentials]
```
