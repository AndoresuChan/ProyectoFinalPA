<template>
    <div class="user">
        <img :src="image" alt="user-image" class="user-image" />
        <div class="user-details">
            <h2>{{ name }}</h2>
            <p class="email">{{ email }}</p>
            <p class="description">{{ description }}</p>
            <router-link :to="{ name: 'UserDetail', params: { id: id } }">
                <button class="detail-button">Ver Perfil</button>
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: 'User',
    props: {
        id: {
            type: Number,
            required: true
        },
        name: {
            type: String,
            required: true
        },
        email: {
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
        }
    }
};
</script>

<style scoped>
.user {
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    margin-bottom: 10px;
    background-color: #7887D3;
    padding: 10px;
    border-radius: 10px;
    margin-bottom: 1rem;
    overflow: hidden;
}

.user-image {
    min-width: 215px; max-width: 215px;
    min-height: 150px; min-height: 150px;
    object-fit: cover;
    margin-right: 10px;
    border-radius: 1px;
}

.user-details {
    flex-grow: 1;
  display: flex;
  flex-direction: column;
}

.user-details h2 {
    margin: 0.5;
  font-size: 1.2rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
}

.email {
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
}

.detail-button:hover {
    background-color: #45a049;
}
</style>