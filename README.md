# Workbench Themes

Two [AtlantaFX](https://github.com/mkpaz/atlantafx) themes, **Workbench Dark** and **Workbench Light**, based on
the color palettes of the IntelliJ themes from
[Familiar Java Themes](https://gitlab.com/zerodind/familiar-java-themes).

The colors (backgrounds, foreground, selection, borders, links, status and syntax colors) are taken from
`intellij-dark-color-theme.json` and `intellij-light-color-theme.json` and mapped onto the AtlantaFX color system.

| AtlantaFX variable | Dark | Light |
| --- | --- | --- |
| `-color-bg-default` (tool window / panel) | `#3C3F41` | `#F2F2F2` |
| `-color-bg-inset` (editors, inputs, lists) | `#2B2B2B` | `#FFFFFF` |
| `-color-fg-default` | `#BBBBBB` | `#000000` |
| `-color-accent-emphasis` (selection) | `#2F65CA` | `#2675BF` |
| `-color-accent-fg` (links) | `#589DF6` | `#006DCC` |
| `-color-success-emphasis` | `#629755` | `#0A7700` |
| `-color-warning-emphasis` | `#F49810` | `#D1820E` |
| `-color-danger-emphasis` | `#BC3F3C` | `#CD0000` |

The remaining steps of each color scale (`-color-base-*`, `-color-accent-*`, ...) are interpolated around these
anchor colors. The chart colors use the syntax colors of the respective theme.

## Usage

The library is not published to Maven Central. Build and install it into your local Maven repository:

```
mvn install
```

Then add it as a dependency (JavaFX itself must be provided by your application):

```xml
<dependency>
    <groupId>io.github.tomarkar</groupId>
    <artifactId>workbench-themes</artifactId>
    <version>1.0.0</version>
</dependency>
```

and set the theme:

```java
Application.setUserAgentStylesheet(new WorkbenchDark().getUserAgentStylesheet());
Application.setUserAgentStylesheet(new WorkbenchLight().getUserAgentStylesheet());
```

`WorkbenchDark` and `WorkbenchLight` implement `atlantafx.base.theme.Theme`, so they also work with `ThemeManager`.
For JPMS, the jar has the automatic module name `io.github.tomarkar.workbench`.

The plain stylesheets can also be used without the Java classes. After `mvn package` they are located in
`target/classes/io/github/tomarkar/workbench/` (`workbench-dark.css`, `workbench-light.css`). Copy them into your
resources and load them directly, e.g.:

```java
Application.setUserAgentStylesheet(getClass().getResource("/workbench-dark.css").toExternalForm());
```

## Build

Requires Maven and JDK 17+. The SASS sources of AtlantaFX are unpacked from the `atlantafx-styles` artifact
into `target/atlantafx/styles`, and both themes are compiled with the `sass-cli-maven-plugin` (Dart Sass is
downloaded automatically):

```
mvn package
```

The theme sources are located in `src/scss/`. Use `mvn compile -Dsass.watch` to recompile them on change.

Without Maven, the themes can also be compiled with the plain [Dart Sass](https://sass-lang.com/dart-sass) CLI.
Copy the `styles/src` folder of the AtlantaFX repository (tag `v3.0.0`) to `target/atlantafx/styles` and run:

```
sass --no-source-map src/scss/workbench-dark.scss workbench-dark.css
sass --no-source-map src/scss/workbench-light.scss workbench-light.css
```

The deprecation warnings printed during the build originate from the AtlantaFX sources and can be ignored.

## License

[MIT](LICENSE). AtlantaFX and Familiar Java Themes are also MIT licensed; see [LICENSE](LICENSE) for their
copyright notices.
