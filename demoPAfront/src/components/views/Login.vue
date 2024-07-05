<template>
  <div class="login-container">
    <div class="login-box">
      <h2>Inicio de sesión</h2>
      <form @submit.prevent="handleSubmit">
        <div class="form-group">
          <label for="username">Nombre de usuario</label>
          <input type="text" id="username" v-model="username" placeholder="Nombre de usuario" required />
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input type="password" id="password" v-model="password" placeholder="*************" required />
        </div>
        <div class="form-group checkbox">
          <input type="checkbox" id="rememberMe" v-model="rememberMe" />
          <label for="rememberMe">Recordar contraseña</label>
        </div>
        <div class="form-group">
          <button type="submit" class="btn">Continuar</button>
        </div>
        <div class="register-link">
          ¿Necesitas una cuenta? <router-link to="/register">¡Regístrate!</router-link>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import users from '@/data/user.json';
import router from '@/router';

export default {
  data() {
    return {
      username: '',
      password: '',
      rememberMe: false
    };
  },
  methods: {
    handleSubmit() {
      const user = users.find(u => u.username === this.username && u.password === this.password);

      if (user) {
        if (user.role === 'ADMIN') {
          router.push('/admin'); 
        } else if (user.role === 'STORE') {
          router.push('/store'); 
        } else if (user.role === 'USER') {
          router.push('/'); 
        }

        if (this.rememberMe) {
          localStorage.setItem('username', this.username);
        }
      } else {
        console.error('Credenciales inválidas');
      }
    }
  }
};
</script>


<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 70vh;
}

.login-box {
  background-color: #6b6bca;
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 8px;
  border: none;
  border-radius: 4px;
}

.checkbox {
  display: flex;
  align-items: center;
}

.checkbox input {
  margin-right: 5px;
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
  background-color: #3a3a82;
}

.register-link {
  text-align: center;
  margin-top: 10px;
}

.register-link a {
  color: white;
  text-decoration: none;
}

.register-link a:hover {
  text-decoration: underline;
}
</style>
