<template>
  <div class="product-list-container">
    <div class="product-grid">
      <ProductItemGrid
        v-for="product in products"
        :key="product.id"
        :id="product.id"
        :name="product.name"
        :price="product.price"
        :image="product.image"
      />
    </div>
  </div>
</template>

<script>
import ProductItemGrid from '../ProductItemGrid.vue';
import api from '../../services/api';

export default {
  name: 'ProductList',
  components: {
    ProductItemGrid
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
    }
  }
};
</script>

<style scoped>
.product-list-container {
  display: flex;
  justify-content: center;
  padding: 20px;
  margin-top: 50px; 
}

.product-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 50px;
}
</style>
