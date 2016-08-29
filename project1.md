Project 1
=========

### Due Monday, September 19, 2016 - 5:00pm

The goal of this project is to implement a program that maintains a database of different types of Pokemon. You will use the following features:

- Classes
- Methods
- File Input
- Iteration
- `ArrayList`

You will implement four classes as part of this assignment. `Pokemon` will track information about one `Pokemon`. `Pokedex` will maintain a list of `Pokemon` and provide methods to find information about the collection of `Pokemon`, including the average experience level, the tallest pokemon, and a list of the most experienced pokemon. The `PokemonBuilder` will create a `Pokedex` by reading information about many pokemon from a text file.

### `Pokemon`

- **Data Members** - A `Pokemon` should have *at least* the following data members:
    * `species` - e.g., zubat 
    * `height` - an integer value
    * `weight` - an integer value
    * `experience` - denoted as base_experience in the data files
    * `favorite` - does not appear in the data file. May default to `false`.
- **Methods** - `Pokemon` will support a constructor that takes initial values for all data members,`get` methods for all data members and a `toString` method that returns a `String` of the following format: `<species>(<height>, <weight>) with experience <experience> - [Not] Starred`
    * Example: `nidoqueen(13, 600) with experience 227 - Not Starred`
    * Example: `jumpluff(8, 30) with experience 207 - Starred`

### `Pokedex`

- **Data Members** - A `Pokedex` should have *at least* the following data members:    
    * `pokemon` - An `ArrayList` containing objects of type `Pokemon`.
 
- **Methods** - The `Pokedex` will implement a default constructor and the following methods:
    * `public void addPokemon(Pokemon pokemon)` - Takes as input a `Pokemon` object and adds it to the `ArrayList` of pokemon in the `Pokedex`.
    * `public String toString()` - Returns a string representation of the `Pokedex`. Each line of the string will contain information about a single `Pokemon` in the format returned by the `Pokemon.toString` method. An example follows:
      	
      	```
      	bulbasaur(7, 69) with experience 64 - Not Starred
		thundurus-therian(30, 610) with experience 261 - Not Starred
		rotom-mow(3, 3) with experience 182 - Not Starred
		castform-sunny(3, 8) with experience 147 - Not Starred
		landorus-therian(13, 680) with experience 270 - Not Starred
		```
		
    * `public double averageHeight()` - Returns the average height of all `Pokemon` in the `Pokedex`.
    * `public double averageWeight()` - Returns the average weight of all `Pokemon` in the `Pokedex`.
    * `public double averageExperience()` - Returns the average experience of all `Pokemon` in the `Pokedex`.
    * `public String tallest()` - Returns the species of the `Pokemon` with the largest height.
    * `public String smallest()` - Returns the species of the `Pokemon` with the smallest weight.
    *	`public ArrayList<Pokemon> mostExperienced(int level)` - Takes as input an experience level and returns a list of all `Pokemon` with experience level *greater than* the level passed as input.

### `PokedexBuilder`

The `PokedexBuilder` will create a new `Pokedex` from a [CSV file](https://en.wikipedia.org/wiki/Comma-separated_values). We will be using the CSV file provided in [this dataset on github](https://github.com/veekun/pokedex).

The first line of the pokemon CSV file will be exactly as follows:

```
id,identifier,species_id,height,weight,base_experience,order,is_default
```

Subsequent lines will provide actual values for the data specified by the first line. Here is a complete example of a valid file:

```
id,identifier,species_id,height,weight,base_experience,order,is_default
1,bulbasaur,1,7,69,64,1,1
10020,thundurus-therian,642,30,610,261,717,0
10012,rotom-mow,479,3,3,182,547,0
10013,castform-sunny,351,3,8,147,420,0
10021,landorus-therian,645,13,680,270,721,0
```

For full credit on this assignment, your program must execute correctly on the following example file: [pokemon.csv](https://raw.githubusercontent.com/veekun/pokedex/master/pokedex/data/csv/pokemon.csv).

Your `PokedexBuilder` class will contain a default constructor and one method defined as follows:

```
public Pokedex buildPokedex(String filename);
```
The logic of the method will be as follows:

1. Instantiate a new `Pokedex`.
2. Create a `File` with the given `filename`.
3. Create a new `Scanner` to read input from the file created in step 2. If a `FileNotFoundException` is generated, return `null`.
4. Specify that that `Scanner` will `useDelimiter(",|\n")`. This indicates that the newline character as well as the comma (,) will separate tokens read by the `Scanner`.
5. Read in the first line and ignore it.
6. As long as there are additional lines in the file:
  - Use the `Scanner` `next` and `nextInt` methods to read in all data from the next line.
  - Create a new `Pokemon` containing the data specified.
  - Add the `Pokemon` to the `Pokedex`.
7. Return the `Pokedex`.
 
### `PokemonDriver`

The `PokemonDriver` will implement the `main` method.

It must take as a command line parameter the name of the file to be processed. It will be run as follows: `project1 srollins$ java PokemonDriver test.csv` where `test.csv` may be replaced by another file name.

The logic of the method will be as follows:

1. If the file name parameter is not present, print an error message and exit the program.
2. Create a new `PokedexBuilder`.
3. Invoke the `buildPokedex` method and save the `Pokedex` returned in a temporary variable.
4. If the `Pokedex` is `null` (for example, because the file was not found), print an error message and exit the program.
5. Display the string `All Pokemon:`. 
6. Use the `Pokedex.toString` method to display the entire `Pokedex`.
7. Display the result of the `averageHeight` method in a string formatted as follows: `"Average Height: <height>`. `<height>` will be replaced by a number. 
8. Display the result of the `averageWeight` method in a string formatted as follows: `"Average Weight: <weight>`. `<weight>` will be replaced by a number. 
9. Display the result of the `averageExperience` method in a string formatted as follows: `"Average Experience: <experience>`. `<experience>` will be replaced by a number. 
10. Display the result of the `tallest` method in a string formatted as follows: `"Species of Tallest: <species>`. `<species>` will be replaced by the string representing the species.
11. Display the result of the `smallest` method in a string formatted as follows: `"Species of Smallest: <species>`. `<species>` will be replaced by the string representing the species.
12. Display the string `Pokemon with experience greater than <level>:`. `<level`> will be replaced by a number.
13. Use iteration and the `Pokemon.toString` method to display information about all `Pokemon` returned by the `mostExperienced` method.

Example output follows:

```
project1 srollins$ java PokemonDriver test.csv
All Pokemon:
bulbasaur(7, 69) with experience 64 - Not Starred
thundurus-therian(30, 610) with experience 261 - Not Starred
rotom-mow(3, 3) with experience 182 - Not Starred
castform-sunny(3, 8) with experience 147 - Not Starred
landorus-therian(13, 680) with experience 270 - Not Starred

Average Height: 11.2
Average Weight: 274.0
Average Experience: 184.8
Species of Tallest: thundurus-therian
Species of Smallest: rotom-mow
Pokemon with experience greater than 200:
thundurus-therian(30, 610) with experience 261 - Not Starred
landorus-therian(13, 680) with experience 270 - Not Starred
```

### Submission Requirements

1. For this assignment, you will submit four files: `Pokemon.java`, `Pokedex.java`, `PokemonBuilder.java`, and `PokemonDriver.java`

2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F16/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F16/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/project1`
