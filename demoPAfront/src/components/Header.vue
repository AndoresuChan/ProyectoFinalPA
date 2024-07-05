<template>
  <header class="header">
    <div class="header-content">
      <router-link :to="{ name: 'ProductList', params: { id: id } }">
        <button class="logo-button" @click="handleClick('home')">
          <img src="./assets/img/logo.png" alt="Logo" class="logo"/>
        </button>
      </router-link>

      <div class="search-bar">
        <input type="text" placeholder="Buscar Productos" v-model="searchQuery"/>
        <button @click="search">Buscar</button>
      </div>

      <div class="header-buttons">
        <router-link :to="{ name: 'Login', params: { id: id } }">
          <button class="profile-button" @click="handleClick('profile')"> 
            <img src="./assets/img/user-icon.png" alt="profile" />
          </button>
        </router-link>

        <router-link :to="{ name: 'Basket', params: { id: id } }">
        <button class="cart-button" @click="handleClick('cart')">
          <img src="./assets/img/cart-icon.png" alt="cart" />
        </button>
        </router-link>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
      searchQuery: ''
    }
  },
  methods: {
    search() {
      console.log('Buscando:', this.searchQuery);
    },
    handleClick(destination) {
      console.log('Navegar a:', destination);
    }
  }
}
</script>

<style scoped>
.header {
  width: 100%;
  background-color: #98A9E1;
  padding: 0.5rem 0;
  text-align: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  z-index: 5000;
}

.header-content {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 1rem;
}

.logo-button,
.profile-button,
.cart-button {
  background: none;
  border: none;
  cursor: pointer;
  font-size: 1.5rem;
}

.logo-button {
  margin-left: auto; 
  margin-right: auto; 
}

.logo {
  height: 65px;
}

.search-bar {
  flex: 1;
  display: flex;
  justify-content: center;
  margin: 0 1rem;
}

.search-bar input {
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ddd;
  border-radius: 4px 0 0 4px;
  width: 100%;
}

.search-bar button {
  padding: 0.25rem 1rem;
  font-size: 1rem;
  border: none;
  background-color: #4CAF50;
  color: white;
  border-radius: 0 4px 4px 0;
  cursor: pointer;
}

.search-bar button:hover {
  background-color: #45a049;
}

.header-buttons {
  display: flex;
  align-items: center;
}

.profile-button {
  margin-left: auto;
  height: 50px;
}

.profile-button img,
.cart-button img {
  height: 40px;
}

.cart-button {
  margin-left: 10px;
  height: 50px;
}
</style>
