<template>
  <div>
    <button @click="navigateToUsers" class="btn-list-users">Lista de Usuarios</button>

    <div class="product-list">
      <ProductItem
        v-for="product in products"
        :key="product.id"
        :id="product.id"
        :name="product.name"
        :price="product.price"
        :image="product.image"
        :description="product.description"
        :supplier="product.supplier"
        :label1="product.label1"
        :label2="product.label2"
      />
    </div>
  </div>
</template>

<script>
import ProductItem from '@/components/ProductItem.vue';
import api from '@/services/api';
import router from '@/router'; 

export default {
  name: 'ProductList',
  components: {
    ProductItem
  },
  data() {
    return {
      products: []
    };
  },
  created() {
    this.fetchProducts();
  },
  methods: {
    async fetchProducts() {
      try {
        const response = await api.get('/products');
        this.products = response.data;
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    },
    removeProduct(id) {
      console.log('Eliminar producto:', id);
    },
    navigateToUsers() {
      router.push('/userList'); 
    }
  }
};
</script>

<style scoped>

.btn-list-users {
  background-color: #4CAF50; 
  color: white;
  padding: 25px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin-bottom: 20px;
  cursor: pointer;
  border: none;
  border-radius: 4px;
}
.product-list {
  max-width: 1200px;
  margin: 1rem auto 0; 
  padding-top: 1.5rem;
}

.btn-list-users:hover {
  background-color: #4848a2;
}
</style>
