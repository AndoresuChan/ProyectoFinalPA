<template>
  <div class="product-detail-container">
    <div class="product-detail">
      <img :src="product.image" alt="Product Image" class="product-image" />
      <div class="product-info">
        <h2 class="product-name">{{ product.name }}</h2>
        <p class="supplier">{{ product.supplier }}</p>
        <p class="price">Precio: {{ product.price }}</p>
      </div>
      <div class="description">
        <h3>Descripción:</h3>
        <p>{{ product.description }}</p>
      </div>
      <button class="remove-button" @click="deleteProduct">Eliminar Producto</button>
    </div>
  </div>
</template>

<script>
import api from '@/services/api'; 

export default {
  name: 'ProductDetail',
  data() {
    return {
      product: {}
    };
  },
  created() {
    const productId = this.$route.params.id;
    this.getProduct(productId);
  },
  methods: {
    async getProduct(productId) {
      try {
        const response = await api.get(`/products/${productId}`);
        this.product = response.data;
      } catch (error) {
        console.error('Error fetching product:', error);
      }
    },
    async deleteProduct() {
      const productId = this.product.id;
      try {
        await api.delete(`/products/${productId}`);
        alert('Producto eliminado correctamente');
        this.$router.push('/admin');
        // Redirigir a la lista de productos u otra acción después de eliminar
        // Puedes redirigir usando this.$router.push('/ruta') si estás usando Vue Router
      } catch (error) {
        console.error('Error deleting product:', error);
        alert('Error al intentar eliminar el producto');
      }
    }
  }
};
</script>

<style scoped>
.product-detail-container {
  display: flex;
  justify-content: center;
  margin-top: 40px; 
}

.product-detail {
  background-color: #7887D3;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  max-width: 1000px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto auto 1fr auto auto;
  gap: 20px;
  align-items: start;
}

.product-image {
  grid-column: 1 / 2;
  grid-row: 1 / 3;
  width: 100%;
  max-width: 300px;
  border-radius: 10px;
}

.product-info {
  grid-column: 2 / 3;
  grid-row: 1 / 3;
}

.product-name {
  font-size: 1.8rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
}

.supplier {
  font-size: 1.5rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
}

.price {
  font-size: 1.5rem;
  font-weight: bold;
  color: white;
  background-color: #474D8C;
  padding: 6px;
  border-radius: 5px;
  text-align: center;
}

.description {
  grid-column: 1 / 3;
  grid-row: 4 / 5;
  background-color: #474D8C;
  color: white;
  padding: 10px;
  border-radius: 10px;
}

.remove-button {
  grid-column: 1 / 3;
  grid-row: 5 / 6;
  background-color: red;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 5px;
  font-size: 1rem;
  margin-top: 20px;
  transition: all 0.3s ease;
  text-align: center;
}

.remove-button:hover {
  background-color: darkred;
  transform: scale(1.02);
}
</style>
