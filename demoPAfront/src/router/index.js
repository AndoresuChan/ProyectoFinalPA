import { createRouter, createWebHistory } from 'vue-router';

import PageNotFound from '@/components/views/PageNotFound.vue';
import UserList from '../components/views/UserList.vue';
import UserDetail from '../components/views/UserDetail.vue';
import Login from '../components/views/Login.vue';
import Register from '../components/views/Register.vue';
import ProductListAdmin from '../components/views/ProductListAdmin.vue';
import ProductDetailAdmin from '../components/views/ProductDetailAdmin.vue';
import ProductList from '../components/views/ProductList.vue';
import ProductDetail from '../components/views/ProductDetail.vue'
import Profile from '../components/views/Profile.vue'
import ProfileEdit from '../components/views/ProfileEdit.vue'
import ProductListStore from '../components/views/ProductListStore.vue'
import ProductDetailStore from '../components/views/ProductDetailStore.vue'
import Basket from '../components/views/Basket.vue'

const routes = [
  {
    path: '/',
    name: 'ProductList',
    component: ProductList,
  },
  {
    path: '/product/:id',
    name: 'ProductDetail',
    component: ProductDetail
  },
  {
    path: '/basket',
    name: 'Basket',
    component: Basket
  },
  {
    path: '/profile',
    name: 'Profile',
    component: Profile
  },
  {
    path: '/profile/edit',
    name: 'ProfileEdit',
    component: ProfileEdit
  },
  {
    path: '/store',
    name: 'ProductListStore',
    component: ProductListStore,
  },
  {
    path: '/store/product/:id',
    name: 'ProductDetailStore',
    component: ProductDetailStore
  },
  {
    path: '/admin',
    name: 'ProductListAdmin',
    component: ProductListAdmin,
  },
  {
    path: '/admin/product/:id',
    name: 'ProductDetailAdmin',
    component: ProductDetailAdmin,
  },
  {
    path: '/userList',
    name: 'UserList',
    component: UserList,
  },
  {
    path: '/user/:id',
    name: 'UserDetail',
    component: UserDetail,
  },
  {
    path: '/:catchAll(.*)*',
    name: 'PageNotFound',
    component: PageNotFound
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
];

export const router = createRouter({
  history: createWebHistory(),
  routes
});
  
export default router;
