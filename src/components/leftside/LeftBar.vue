<template>
    <div class="leftbar">
    <Profile/>
    <Menu @hidemenu="$emit('hidemenu')"/>
    </div>
</template>

<script>
    import Profile  from "./Profile";
    import Menu from "./Menu";
  export default {
    name: "LeftBar",
    components:{
      Profile,
      Menu
    }
  }
</script>

<style lang="less" scoped>
    .leftbar::-webkit-scrollbar{
        display: none;
    }
    .leftbar{
        overflow: auto;
        z-index: 1000;
        bottom: 0;
        top:0;


    }
    @media screen and (min-width: 800px) {
        .leftbar{
            width:250px;
            min-width: 250px;
            background-color: white;
            min-height: 100vh;
            position:fixed;
            /*border-right: #e8d72f 3px solid;*/
            box-shadow: 1px 0 10px rgba(100,100,100,.3);
            /*outline-color: #fffef0;*/
            /*outline-style: groove;*/
            border-top-left-radius: 10px;
        }

    }
    @media screen and (max-width: 800px) {
        .leftbar{
            width:100px;
            min-width: 250px;
            background-color: #fff;
            min-height: 100vh;
            position:fixed;
            transform: translate3d(-250px,0,0);
            transition: .5s ease all;
            /*border-right: #ffa74b 3px solid;*/
            /*border-right: #e8d72f 3px solid;*/
            z-index: 2;
            /*border-right: rgba(255, 242, 173, 0.5) solid 1px;*/
        }

    }

</style>