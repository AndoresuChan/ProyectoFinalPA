<template>
    <div class="card">
        <img :src="user.image" alt="User Image" class="profile-pic" />
        <div class="info">
            <h2>{{ user.name }}</h2>
            <p class="email">{{ user.email }}</p>
            <div class="description">
                <p>{{ user.description }}</p>
            </div>
        </div>
        <button class="delete-button">Eliminar Usuario</button>
    </div>
</template>

<script>
import userData from '@/data/users.json';

export default {
    name: 'UserDetail',
    data() {
        return {
            user: null
        };
    },
    created() {
        this.$route.params.id
        const userId = parseInt(this.$route.params.id);
        this.user = userData.find(user => user.id === userId);
    }
};
</script>

<style scoped>
.card {
    margin: auto;
    background-color: #7887D3;
    border: 2px solid #ccc;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 50%;
    text-align: center;
    padding: 5rem;
    
}

.profile-pic {
    border-radius: 50%;
    width: 200px;
    height: 200px;
    object-fit: cover;
}

.info {
    margin-top: 20px;
}

.info h2 {
    font-size: 24px;
    color: white;
    margin: 0;
}

.email {
    color: white;
    margin: 10px 0;
}

.description {
    background-color: #474D8C;
    color: white;
    padding: 10px;
    border-radius: 5px;
    margin: 20px 0;
}

.delete-button {
    background-color: #e74c3c;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.delete-button:hover {
    background-color: #c0392b;
}
</style>
