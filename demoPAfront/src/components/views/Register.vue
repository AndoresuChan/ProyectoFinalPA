<template>
    <div class="register-container">
      <div class="register-box">
        <h2>Registrar Cuenta</h2>
        <form @submit.prevent="handleSubmit">
            <div class="form-group">
            <label for="name">Nombre de usuario</label>
            <input type="name" id="name" v-model="name" placeholder="Nombre de usuario" required />
          </div>
          <div class="form-group">
            <label for="email">Correo</label>
            <input type="email" id="email" v-model="email" placeholder="persona@correo.com" required />
          </div>
          <div class="form-group">
            <label for="password">Contraseña</label>
            <input type="password" id="password" v-model="password" placeholder="*************" required />
          </div>
          <div class="form-group">
            <button type="submit" class="btn">Registrar</button>
          </div>
          <div class="login-link">
            ¿Ya tienes una cuenta? <a href="/login">Inicia Sesión!</a>
          </div>
        </form>
      </div>
    </div>
  </template>

  <script>

  </script>

  <style scoped>
    .register-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 70vh;
    }

    .register-box {
        background-color: #6b6bca;
        padding: 40px;
        border-radius: 20px;
        width: 400px;
    }

    h2 {
        color: white;
        text-align: center;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        color: white;
        margin-bottom: 5px;
    }

    input[type="name"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        border: none;
        border-radius: 4px;
    }

    .btn {
        width: 100%;
        padding: 10px;
        background-color: #4848a2;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    .btn:hover {
        background-color: #3a3a7f;
    }

    .login-link {
        text-align: center;
        margin-top: 10px;
    }

    .login-link a {
        color: white;
        text-decoration: none;
    }

    .login-link a:hover {
        text-decoration: underline;
    }

  </style>