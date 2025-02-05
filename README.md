# Be-an-Artist

[![Java](https://img.shields.io/static/v1?style=flat&message=Java&logo=java&labelColor=007396&color=007396&logoColor=F89820&label=%20)](https://www.java.com/fr/)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/51faf1bc993e45ff8d90a96d51a9a36a)](https://app.codacy.com/gh/EdouardGautier/Be-an-Artist?utm_source=github.com&utm_medium=referral&utm_content=EdouardGautier/Be-an-Artist&utm_campaign=Badge_Grade_Settings)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/75b2a480fe3647cb93edc2e6bd5673e2)](https://www.codacy.com/gh/EdouardGautier/Be-an-Artist/dashboard?utm_source=github.com&utm_medium=referral&utm_content=EdouardGautier/Be-an-Artist&utm_campaign=Badge_Coverage)

<p align="center">
<img  src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Logo_ESEO_GROUPE.jpg/1280px-Logo_ESEO_GROUPE.jpg" width="400" height="">
</p>

## Preamble

The objective of the project is to develop a graphic editor offering similar functionalities to those provided by well known software (eg Dia, Inkscape or MSPaint).
The editor that is designed in this work will allow to draw geometric shapes such as lines, ellipses, circles and stars.
To program this application, we will follow the software architectural pattern Model-View-Controller (MVC). This architecture specifies a methodology to facilitate the development of an interactive graphic application.

## Launching

To launch the application, you just have to execute the command `java -jar Be-An-Artist.jar` at the root of the project.
An interface is launched in order to use all the tools proposed

![launch window](ReadMe/Interface.png)

You can, by pressing the appropriate button, then draw :

- Shapes
  - Lines
  - Circles
  - Ellipses
  - Stars (choice of the length and the number of possible branches)
  - Rectangle
  - Squares

## Usage

You can easily draw any shape, after choosing it with a button, by a simple mouse click in the drawing area.
With the button `Choisir une couleur` you can change the color of your shapes.

![Color](ReadMe/Couleurs.png)

And by checking the `Remplissage de la Forme` box the shapes you draw take the selected color.

![Drawings](ReadMe/Dessins.png)

By clicking on the `Sélectionner` button and choosing a shape that has already been drawn you can retrieve the informations about it.

![Info](ReadMe/Info.png)

## Limits ⚠️

The code is in French.
