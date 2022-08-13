# LeetCode

## Code agenda
- [topic](https://github.com/Allsochen/LeetCode/tree/main/src/main/java/leetcode/editor/cn/doc/content)
- [code](https://github.com/Allsochen/LeetCode/tree/main/src/main/java/leetcode/editor/cn)

## Idea Plugin Install

- Install leedcode plugin
- configurate leedcode template
- Temp File Path
```text
PROJECT_GIT_REPO\src\main\java
```
- Code FileName
```text
$!velocityTool.camelCaseName(${question.titleSlug})
```

- Code Template
```text
${question.content}
  
package leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug}){

    public static void main(String[] args) {
        Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    ${question.code}
}
```