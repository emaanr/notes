# Markdown

    Markdown notes.

# Table of Contents

- [Markdown](#markdown)
- [Table of Contents](#table-of-contents)
- [Images](#images)
- [Custom Style](#custom-style)
  - [Custom Tags](#custom-tags)
  - [Overwriting Tags](#overwriting-tags)
- [Diff Syntax Highlighting](#diff-syntax-highlighting)

# Images

- Can include images using HTML tags.

```html
<p align="center" width="100%">
    <img src="path">
</p>
```

# Custom Style

- Define styling using `<style></style>` tags at the start of any Markdown file.

```html
<style>
  /* Custom Styling goes here */
</style>

<!-- Reminaing Markdown File -->
```

## Custom Tags

- Define custom tags to use throughout file to avoid clutter.

```html
<style>
  r { color: Red }
</style>
```
```html
<!-- Example -->
<r>This will be Red</r>
 ```

## Overwriting Tags

- Remove pre-existing styling that exists and replace those with styles that are actually needed for any particular file.

```html
<!-- Removing Pre-Existing Styling -->
<style>
    s { text-decoration: none }   /* Strike-Through */
    em { font-style: normal }     /* Italic Emphasis */
</style>


<!-- Overwriting with Color Styling -->
<style>
    s { color: Seagreen }
    em { color: Red }
</style>
```
```html
<!-- Example -->
~~This will be Seagreen~~
 _This will be Red_
 ```

 # Diff Syntax Highlighting

- Use ` ```diff ` for code blocks to enable syntax highlighting when using `+` indicating added lines and `-` indicating removed lines.

```html
```diff <!-- Start -->
public class Hello1
{
   public static void Main()
   {
-      System.out.Println("Removed Line");
+      System.out.Println("Added Line in Removed Line's place");
   }
}
``` <!-- End -->
```
```diff
public class Hello1
{
   public static void Main()
   {
-      System.out.Println("Removed Line");
+      System.out.Println("Added Line in Removed Line's place");
   }
}
```