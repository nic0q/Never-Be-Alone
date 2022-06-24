<template>
  <div>
    <UserLogin></UserLogin>
  </div>
</template>

<script>
// @ is an alias to /src
import UserLogin from '@/components/UserLogin.vue'
export default {
  name: 'HomeView',
  components: {
    UserLogin
  }
}
</script>
