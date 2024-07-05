<template>
  <div class="product-item">
    <img :src="image" alt="Product Image" class="product-image" />
    <div class="product-details">
      <h2>{{ name }}</h2>
      <p class="price">{{ price }}</p>
      <p class="description">{{ description }}</p>
      <router-link :to="{ name: 'ProductDetailAdmin', params: { id: id } }">
        <button class="detail-button">Ver detalles</button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProductItem',
  props: {
    id: {
      type: Number,
      required: true
    },
    name: {
      type: String,
      required: true
    },
    price: {
      type: String,
      required: true
    },
    image: {
      type: String,
      required: true
    },
    description: {
      type: String,
      required: true
    },
    supplier: {
      type: String,
      required: true
    },
    label1: {
      type: String,
      required: true
    },
    label2: {
      type: String,
      required: true
    }
  },
  methods: {
  }
};
</script>

<style scoped>
.product-item {
  display: flex;
  align-items: center;
  border: 1px solid #ccc;
  margin-bottom: 10px;
  background-color: #7887D3;
  padding: 10px;
  border-radius: 10px;
  overflow: hidden;
}

.product-image {
  min-width: 215px; max-width: 215px;
  min-height: 150px; min-height: 150px;
  object-fit: cover;
  margin-right: 10px;
  border-radius: 1px;
}

.product-details {
  flex-grow: 1;
  display: flex;
  flex-direction: column;
}

.product-details h2 {
  margin: 0.5;
  font-size: 1.2rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
}

.price {
  font-size: 1.1rem;
  font-weight: bold;
  color: white;
  background-color: #474D8C;
  padding: 5px;
  border-radius: 5px;
  align-self: flex-start;
}

.description {
  margin: 5px 0;
  background-color: #474D8C;
  color: white;
  padding: 5px;
  border-radius: 5px;
}

.detail-button {
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 5px;
  cursor: pointer;
  border-radius: 5px;
  width: 10%;
  transition: all 0.5s ease;
}

.detail-button:hover {
  background-color: #45a049;
  transform: scale(1.01);
}
</style>
