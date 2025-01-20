[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses
### Java Jester
| Stats | Description |
|:------|:------------|
| HP | 80 |
| SillinessMax | 15 |
| Attack: Recursion | Releases a function that does 1-3 damage per iteration for a total of 7 iterations. If total damage is less than 14, restore 1 silliness. Otherwise, restore 2 silliness.|
| Special: StackOverflow | Releases a function that does 1-3 damage per iteration, with a 10% chance to stop after each iteration. Otherwise, it continues another iteration. Uses 10 silliness. |
| Support: IndexOutOfBoundsException| Restores 1/2 of the special meter of any given ally but loses the special meter of its own or restores special to max but loses 5 HP |

### Python Prince
| Stats | Description |
|:------|:------------|
| HP | 50 |
| CharmMax | 10 |
| Attack: Static Method | Deals 1 damage for every HP less than the max and restores charm only if attack isn't multiplied by Overwrite |
| Special: Class Method | The same as the basic attack but afterwards, restores own HP to max. Reduces 7 charm. |
| Support: Overwrite | Takes 5 HP from ally to deal 1.5x damage, or loses 10HP to deal 1.5x damage to enemy on next turn. Does not work with special and does not stack |

### Code Warrior
| Stats | Description |
|:------|:------------|
| HP | 100 |
| CaffeineMax | 12 |
| Attack: Basic Strike | Deals 7-16 damage, restores 2 caffeine. |
| Special: Caffeine Overdose | Deals 15-30 damage, reduces 8 caffeine. |
| Support: Daily Coffee | Gives a cup of coffee. Restores 20 HP to other. Restores 6 caffeine and 10 hp to self. |


replace this with your documentation for your two Adventurer subclasses. If you modify or replace the provided CodeWarrior class, please provide documentation for that as well.
