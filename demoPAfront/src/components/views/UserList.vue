<template>
    <div class="user-list">
        <User
            v-for="user in users"
            :key="user.id"
            :id="user.id"
            :name="user.name"
            :email="user.email"
            :image="user.image"
            :description="user.description"
            @remove="removeUser"
        />
        </div>
</template>

<script>
import User from '@/components/User.vue';
import userData from '@/data/users.json';

export default {
    name: 'UserList',
    components: {
        User
    },
    data() {
        return {
            users: userData
        };
    },
    methods: {
        removeUser(id) {
            this.users = this.users.filter(user => user.id !== id);
        }
    }
};
</script>

<style scoped>
.user-list {
    max-width: 1200px;
    margin: 0 auto;
    padding-top: 1.5rem;
}
</style>