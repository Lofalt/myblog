<template>
    <div class="main">
        <router-view/>
    </div>
</template>

<script>
  export default {
    name: "Main"
  }
</script>

<style scoped>
    .main{
        min-height: 96vh;
        background-color: floralwhite;
        /*display: flex;*/
        /*justify-content: center;*/
        /*align-items: center;*/
    }
</style>