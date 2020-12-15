#!/bin bash

JAVA_HOME=/usr/lib/jvm/default-java
PATH_TO_FX=/usr/share/openjfx/lib

$JAVA_HOME/bin/java --module-path "$PATH_TO_FX" \
  --add-modules javafx.controls \
  --add-modules javafx.fxml \
  --add-modules javafx.swing \
  --add-modules javafx.media \
  -jar COSMOS-1.1-all.jar
