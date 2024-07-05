<template>
  <div class="product-list-container">
    <button @click="showAddProductModal = true" class="add-product-button">Agregar productos</button>
    
    <div v-if="showAddProductModal" class="modal">
      <div class="modal-content">
        <span class="close" @click="showAddProductModal = false">&times;</span>
        <h2>Agregar Producto</h2>
        <form @submit.prevent="submitProduct">
          <div class="form-group">
            <label for="name">Nombre:</label>
            <input type="text" id="name" v-model="newProduct.name" required>
          </div>
          <div class="form-group">
            <label for="price">Precio:</label>
            <input type="number" id="price" v-model="newProduct.price" required>
          </div>
          <div class="form-group">
            <label for="image">Imagen URL:</label>
            <input type="text" id="image" v-model="newProduct.image" required>
          </div>
          <div class="form-group">
            <label for="description">Descripción:</label>
            <textarea id="description" v-model="newProduct.description" required></textarea>
          </div>
          <button type="submit">Agregar</button>
        </form>
      </div>
    </div>

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

export default {
  name: 'ProductList',
  components: {
    ProductItem
  },
  data() {
    return {
      products: [],
      showAddProductModal: false,
      newProduct: {
        name: '',
        price: '',
        image: '',
        description: '',
        supplier: '',
        label1: '',
        label2: ''
      }
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
    async submitProduct() {
      try {
        const response = await api.post('/products', this.newProduct);
        this.products.push(response.data);
        this.showAddProductModal = false;
        this.newProduct = {
          name: '',
          price: '',
          image: '',
          description: '',
          supplier: '',
          label1: '',
          label2: ''
        };
      } catch (error) {
        console.error('Error adding product:', error);
      }
    }
  }
};
</script>

<style scoped>
.product-list-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  margin-top: 50px; 
}

.add-product-button {
  background-color: #4CAF50; 
  color: white;
  padding: 15px 32px;
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
  margin: 0 auto;
  padding-top: 1.5rem;
}

.modal {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgb(0, 0, 0);
  background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
  background-color: #fefefe;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  max-width: 500px;
  border-radius: 10px;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

.form-group textarea {
  resize: vertical;
  height: 100px;
}
</style>
