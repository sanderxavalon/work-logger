<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <MarkdownExample />
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import MarkdownExample from './components/MarkdownExample.vue'
export default {
  name: 'App',
  components: {
    HelloWorld,
    MarkdownExample
  }
}
</script>

<style>

</style>
