<template>
  <div class="app-container">
    <v-md-editor
      v-model="content"
      :disabled-menus="[]"
      height="600px"
    />
  </div>
</template>

<script>
import example from './example'
import VMdEditor from '@kangc/v-md-editor'
import enUS from '@kangc/v-md-editor/lib/lang/en-US'
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js'
import createEmojiPlugin from '@kangc/v-md-editor/lib/plugins/emoji/index'
import createTodoListPlugin from '@kangc/v-md-editor/lib/plugins/todo-list/index'
import createMermaidPlugin from '@kangc/v-md-editor/lib/plugins/mermaid/npm'
import createTipPlugin from '@kangc/v-md-editor/lib/plugins/tip/index'
import hljs from 'highlight.js'

VMdEditor.use(githubTheme, {
  Hljs: hljs
})
VMdEditor.lang.use('en-US', enUS)
VMdEditor.use(createEmojiPlugin())
VMdEditor.use(createTodoListPlugin())
VMdEditor.use(createMermaidPlugin())
VMdEditor.use(createTipPlugin())

export default {

  components: {
    VMdEditor
  },
  data: function() {
    return {
      content: example
    }
  }
}

</script>

<style>

@import '~@kangc/v-md-editor/lib/style/base-editor.css';
@import '~@kangc/v-md-editor/lib/theme/style/github.css';
@import '~@kangc/v-md-editor/lib/plugins/emoji/emoji.css';
@import '~@kangc/v-md-editor/lib/plugins/todo-list/todo-list.css';
@import '~@kangc/v-md-editor/lib/plugins/mermaid/mermaid.css';
@import '~@kangc/v-md-editor/lib/plugins/tip/tip.css';
</style>
