[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: drawBackground()

:white_check_mark: drawText()

:white_check_mark: TextBox()

:white_check_mark: createRandomAdventurer()

:white_check_mark: drawParty()

:white_check_mark: colorByPercent()

:white_check_mark: drawScreen()

:white_check_mark: userInput()

:white_check_mark: quit()

:white_check_mark: run()

:white_check_mark: Java Jester

:white_check_mark: Python Prince

:white_check_mark: Code Warrior

:white_check_mark: Tank

:white_check_mark: Sharpshooter

:white_check_mark: Swords Machine

:white_check_mark: Boss

:white_check_mark: Play with a group of 3 different types adventurers

:white_check_mark: Play against 1-3 randomly chosen adventurer opponents

:white_check_mark: Use attack/special operations on your opponents

:white_check_mark: Use support operations on your team

:white_check_mark: Program ends when the user choosed to quit, or all enemies is defeated, or the entire party is defeated. 

:white_check_mark: Have a win/lose screen

:white_check_mark: Display the results of the attack/special/support inside your border. 

:white_check_mark: Have a special boss class adventurer for when a single opponent is selected.

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

## Enemy Subclasses
### Tank
| Stats | Description |
|:------|:------------|
| HP | 120 |
| Attack | Deals 10 damage |
| Support | Heals 25 HP to itself |

### Sharpshooter
| Stats | Description |
|:------|:------------|
| HP | 50 |
| Attack | Deals 20 damage |
| Support | Doubles the attack damage on next turn (20 -> 40) |

### Swords Machine
| Stats | Description |
|:------|:------------|
| HP | 70 |
| Attack | Deals 20 damage and adds 10 gluttony to the meter |
| Support | Heals the value of gluttony in the meter |

### Boss: Virus
| Stats | Description |
|:------|:------------|
| HP | 200 |
| Attacks | Lifesteal: Take 15 HP from an opponent |
| | Heavy Hitter: Does 25-35 damage to an opponent |
| | Poison: Picks an opponent to poison for the rest of the game, dealing 10 damage per turn. If poison is called again, the opponent poisoned changes |
| Supports | Double damage: Does double damage on the next turn |
| | Heal: Heals 50 HP |
