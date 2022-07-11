<template>
    <div class="rightside">
<!--        <keep-alive>-->
            <router-view class="view"/>
<!--        </keep-alive>-->
        <Footer/>
    </div>
</template>

<script>
    import Main from './Main'
    import Footer from './Footer'
  export default {
    name: "RightSide",
    components:{
      Main,
      Footer
    }
  }
</script>

<style lang="less" scoped>
    .rightside{
        transition: .5s all ease;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        /*justify-content: left;*/
        border-top-right-radius: 10px;
        .view{
            min-height: 100vh;
        }
    }

    @media screen and (min-width: 800px) {
        .rightside{
            min-height: 100%;
            background-color: floralwhite;
            margin-left:250px;
        }
    }
    @media screen and (max-width: 800px) {
        .rightside{
            min-height: 100%;
            background-color: floralwhite;
            margin-left:0;
        }
    }
    .aside{
        flex: 1;
    }
</style>