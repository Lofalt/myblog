<template>
  <div id="app">
    <div :style="{transform:currentButtonTransform}" class="navButton" @click="showNav">
      <div class="icons"></div>
      <div class="icons"></div>
      <div class="icons"></div>
    </div>
    <leftbar ref="left" :style="{ transform:currentTransform}" class="left" @hidemenu="hideMenu"/>
    <rightbar ref="right" :style="{transform:currentRightTransform}" />
      <div ref="back"  :style="{display:isBack}"  class="back" @click="showNav"></div>
  </div>
</template>
<script>
  import 'element-ui/lib/theme-chalk/index.css'
  import 'element-ui/lib/theme-chalk/display.css';
  import leftbar from './components/leftside/LeftBar'
  import rightbar from './components/rightside/RightSide'
  // import 'highlight.js/styles/arduino-light.css'
  import validUser from "./util/validUser";
  export default{
    components:{
      leftbar,
      rightbar
    },
    data(){
      return {
        currentTransform : '',
        currentRightTransform:'',
        currentButtonTransform:'',
        currentFilter:'',
        isActive:false,
        screenwidth:null,
        isBack:'none',
        user:null
      }
    },
    computed:{
      needBack(){
        if(this.isActive){
          return ''
        }else{
          return 'none'
        }
      }
    },
    methods:{
      showNav(){
        if(!this.isActive) {
          this.isBack = ''
          this.isActive = !this.isActive
          this.currentTransform = 'translate3D(0,0,0)'
          this.currentRightTransform = 'translate3D(250px,0,0)'
          this.currentButtonTransform = 'translate3D(250px,0,0)'
        }else{
          this.isBack = 'none'
          this.currentTransform = 'translate3D(-250px,0,0)'
          this.currentRightTransform = 'translate3D(0,0,0)'
          this.currentButtonTransform = 'translate3D(0,0,0)'
          this.isActive = !this.isActive
        }
      },
      hideMenu(){
        if(this.isActive && parseInt(this.screenwidth)<=800) {
          this.showNav()
        }
      }
    },
    mounted() {
      this.screenwidth = document.body.clientWidth;
      window.onresize = ()=>{
        return (()=>{
          this.screenwidth = document.body.clientWidth;
        })()
      }
      this.$store.commit('updateToken',window.localStorage.getItem('token'))
      // if(window.localStorage.getItem('token')) {
      if(window.localStorage.getItem('token')){
        // var tmp  = { user:null }
        // console.log(tmp);
        validUser(window.localStorage.getItem('token'),this)
      }
    },
    watch:{
      screenwidth(val){
        if(val>800){
          this.currentTransform = ''
          this.currentRightTransform = ''
          this.currentButtonTransform = ''
          this.isBack = 'none'
        }
      },
      'user'(val){
        this.$store.commit('updateUser',val)
      }
    }
  }
</script>
<style lang="less">
  @import url('~assets/css/base.css');
  @import "~assets/css/app.css";

  .icons{
    height: 2px;
    min-width: 20px;
    margin: 5px 8px;
    background-color: #ffa74b;
    border-radius: 5px;
    &:nth-of-type(1){
      margin-top:8px;
    }
    &:nth-of-type(3){
      margin-bottom:8px;
    }
  }

</style>
