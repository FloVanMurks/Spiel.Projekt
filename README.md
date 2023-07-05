# Spiel.Projekt

## Disclaimer
This is a school project with "amateur skills" built with Greenfoot. It tries to replicate Space Invaders but with some extra-features.
We are thankful for any corrections that are not too high level.

## Functionality
All buttons have different actions. For every button a name is handed over so "the button has to know what he has to do". 

All actions triggered by buttons are controlled from the *Button* class.

**Important!!** Normally every button changes the visible page and with that the status after *state transition diagram*. So, in the if-branch of the *act*-method the *My-World.status* has to be changed (or rather the buttons for the individual pages are ordered by the *Button*-class object).