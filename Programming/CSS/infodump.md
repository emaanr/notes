# Infodump

    Place to dump information so I don't get so hung up on organizing it right away.

# Table of Contents

- [Infodump](#infodump)
- [Table of Contents](#table-of-contents)
  - [What Is CSS](#what-is-css)
  - [CSS Declarations](#css-declarations)
  - [CSS Selectors](#css-selectors)
    - [Basic Selectors](#basic-selectors)
      - [Name](#name)
      - [Id](#id)
      - [Class](#class)
        - [Name.Class](#nameclass)
      - [Universal Selector](#universal-selector)
      - [Grouping Selectors](#grouping-selectors)
    - [Combinator Selectors](#combinator-selectors)
      - [Descendant ` `](#descendant--)
      - [Child `>`](#child-)
      - [Next Sibling `+`](#next-sibling-)
      - [Subsequent Sibling `~`](#subsequent-sibling-)
      - [Complex Selectors (w/ Nesting)](#complex-selectors-w-nesting)
    - [Pseudo-Class Selectors](#pseudo-class-selectors)
    - [Pseduo-Element Selectors](#pseduo-element-selectors)
    - [Attribute Selectors](#attribute-selectors)
  - [DOM](#dom)
  - [Three Ways to Add CSS](#three-ways-to-add-css)
    - [Inline Styling](#inline-styling)
    - [ Tag](#-tag)
  - [Conventions](#conventions)
    - [BEM](#bem)

## What Is CSS

- Stands for "Cascading Style Sheet".
- Allows you to style HTML page.
- First introduced in 1996 as "CSS 1", or, "CSS Version 1".
- Two years later, in 1998, released "CSS 2" or, "CSS Version 2".
- The latest version of CSS, "CSS 3", or "CSS Version 3", is currently in development still.
- There will never be a "CSS 4".
  - This is because with "CSS Version 3", the approach towards the development of CSS changed.
  - Rather than focusing on different versions, they now split up CSS into a couple of "Modules" which are organized by the feature they cover.
    - Instead there are different versions of these "Modules", such as, " Color 3, Color 4, ..." and so on so forth.
- See [World Wide Web Consortium (W3C)](https://www.w3.org/) for more information about CSS development.
  - See [W3C CSS Working Groups](https://www.w3.org/TR/tr-groups-all#tr_Cascading_Style_Sheets__CSS__Working_Group)

## CSS Declarations

- Declare what you want to style and how.
- "What" is the "Property" and "How" is the legal "Value" provided to it.
  - Different properties accept different kinds of values.

```html
<!-- The "background: red" portion in its entirety is considered a "Declaration" -->
<div style="background: red">Text</div>
```

## CSS Selectors

- Used to "find" which HTML element(s) to select in DOM when applying the changes made by CSS declarations.
- Can be dividied into categories:
- Basic:
  - Element Name, Id, Class
- Combinator:
  - Specific Releationship Between Elements
- Pseudo-Class:
  - Certain State
- Pseudo-Element:
  - Part of an Element
- Attribute:
  - Attribute or Attribute Value

### Basic Selectors

| Basic Selector        | Example       | Description                                           |
| --------------------- | ------------- | ----------------------------------------------------- |
| #id                   | `#id-name`    | Selects the element with `id="id-name"`               |
| .class                | `.class-name` | Selects all elements with `class="class-name"`        |
| element.class         | `p.classname` | Selects only `<p>` elements with `class="class-name"` |
| \*                    | `*`           | Selects all elements                                  |
| element               | `p`           | Selects all `<p>` elements                            |
| element, element, ... | `div, p`      | Selects all `<div>` elements and all `<p>` elements   |

- Select elements based on element name, id, or class.

#### Name

- The "Name Selector" selects HTML elements based on the element name.

```css
p {
  property: value;
}
```

#### Id

- The "Id Selector" selects HTML elements using the value of their `id` attribute.
- The `id` of an element is always unique in the scope of the page it is on, so the `id` selector is used to select one unique element.
- The `id` attribute can be selected by preceding its name with a `#`.

```css
#id-name {
  property: value;
}
```

#### Class

- The "Class Selector" selects HTML elements using the value of their `class` attribute.
- The `class` attribute can be selected by preceding its name with a `.`.

```css
.class-name {
  property: value;
}
```

##### Name.Class

- The "Name.Class Selector" can further specify scope of styling by selecting specific elements with a specific class to be affected.
- This can be done by preceding the `.class-name` with the name of the element, such as `p` or `div`, resulting in `p.class-name` or `div.class-name`, for example.

```css
p.class-name {
  property: value;
}
```

- Note that elements can have multiple classes and as a result can be styled via different classes.

```html
<p class="one two">This paragraph refers to two classes.</p>
```

```css
p.one {
  property: value;
}

p.one {
  property: value;
}
```

#### Universal Selector

- The "Universal Selector" is denoted by an asterisk `*` and selects all HTML elements on a page.

```css
/* This would select and apply CSS declarations to all elements on a page*/
* {
  property: value;
}
```

#### Grouping Selectors

- The "Grouping Selector" selects a set of HTML elements and applies the same style definitions.
- The following CSS declarations can be combined into one using a comma separated list as shown.

```css
h1 {
  property1: value1;
  property2: value2;
}

h2 {
  property1: value1;
  property2: value2;
}

h3 {
  property1: value1;
  property2: value2;
}
```

```css
h1,
h2,
h3 {
  property1: value1;
  property2: value2;
}
```

### Combinator Selectors

| Combinator Selector |  Example  | Description                                                                       |
| ------------------- | :-------: | --------------------------------------------------------------------------------- |
| element element     |  `div p`  | Selects all `<p>` elements inside `<div>` elements                                |
| element > element   | `div > p` | Selects all `<p>` elements that are direct children of a `<div>` parent element   |
| element + element   | `div + p` | Selects the first `<p>` element that is placed immediately after `<div>` elements |
| element ~ element   | `div ~ p` | Selects all `<p>` elements that are next siblings of `<div>` elements             |

- Selects elements based on specific releationship between elements.
- There are four different combinators in CSS:
  1. Descendant Combinator ` `
  2. Child Combinator `>`
  3. Next Sibling Combinator `+`
  4. Subsequent Sibling Combinator `~`

#### Descendant ` `

- The "Descendant Combinator" combines two selectors such that the elements matched by the second selector are selected if they have an ancestor (parent, parent's parent, so on so forth) element matching the first selector.
  - Selectors can be the name of the element or even the value of an `id` or `class` attribute since, as previously discussed, they are all classified as basic selectors.
- The following example selects all `<p>` elements inside `<div>` elements:

```css
div p {
  property: value;
}
```

```html
<!-- This p tag is affected because it has div as an ancestor element -->
<div><p>Text in div.</p></div>
<!-- This p tag is NOT affected because it does NOT have div as an ancestor element -->
<p>Text not in div.</p>
```

#### Child `>`

- The "Child Combinator" selects all elements that are _direct_ children of a specified parent element such that the element after `>` is the _direct_ child of the parent element before `>`.
  - That is, descendant elements further down the hierarchy don't match.
- The following example selects all `<li>` elements that are direct children of a `<ul>` parent element:

```css
ul > li {
  property: value;
}
```

```html
<ul>
  <!-- This li is affected -->
  <li>Unordered item</li>
  <li>
    <!-- This li is affected -->
    Unordered item
    <ol>
      <!-- This li is NOT affected -->
      <li>Item 1</li>
      <!-- This li is NOT affected -->
      <li>Item 2</li>
    </ol>
  </li>
</ul>
```

#### Next Sibling `+`

- The "Next Sibling Combinator" is used to select elements matched by the second selector that is directly/immediately after the elements matched by the first selector.
- The following example selects the first `<p>` element that is placed immediately after `<h1>` elements:

```css
h1 + p {
  property: value;
}
```

```html
<article>
  <h1>A heading</h1>
  <!-- This p is affected -->
  <p>Some paragraph content.</p>
  <!-- This p is NOT affected -->
  <p>Some paragraph content.</p>
</article>
```

#### Subsequent Sibling `~`

- The "Subsequent Sibling Combinator" selects all elements that are siblings of a specified element, even if they are not directly adjacent.
  - That is, they come _anywhere_ after on the _same level_.
- The following example selects all `<p>` elements that are next siblings of `<div>` elements:

```css
h1 ~ p {
  property: value;
}
```

```html
<article>
  <h1>A heading</h1>
  <div>
    <!-- This p is NOT affected because it is a child of div who is a sibling of h1, not a sibling of h1 -->
    <p>I am a paragraph.</p>
  </div>
  <div>I am a div</div>
  <!-- This p is affected because it is a sibling of h1 -->
  <p>I am another paragraph.</p>
</article>
```

#### Complex Selectors (w/ Nesting)

- The [CSS Nesting Module](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_nesting/Using_CSS_nesting#combinators) allows you to write nested rules that use combinators to create [Complex Selectors]()

### Pseudo-Class Selectors

### Pseduo-Element Selectors

### Attribute Selectors

## DOM

- Stands for "Document Object Model".

## Three Ways to Add CSS

### Inline Styling

- Add the `style` atribute to the opening tag of an HTML element.
  - `<div style=""></div>` or `<div style="" />`
- `style` is a normal HTML attribute that you can add to pretty much any element.
- Can apply CSS styling by add "CSS Declarations" inside the `""` portion of the `style=""` attribute.
- You can have multiple CSS declarations in an inline style by adding a "Semicolon" to the end of one property berfore declaring the next one.

```html
<!-- Will have a red background with white text -->
<div style="background: red; color: white;">Text</div>

<!--
    The last property declared doesn't necessarily need to end in a semicolon. However,
    it is good practice to do so for every declaration. This achieves the same result.
-->
<div style="background: red; color: white">Text</div>
```

- Inline styling is generally not recommended:
  - Harder to read and understand code as project grows.
  - Difficult to make changes since you have to identify where to make the change in a sea of messiness.
  - Makes it less readable in general but especially in the case where you have a ton of properties declared.

### <style> Tag

- Special `<style></style>` tag can be added between the `<head></head>` tags of HTML document.
- Now you can define CSS in between these `<style>` tags using "CSS Selectors".

## Conventions

### BEM
