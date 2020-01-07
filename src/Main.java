
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Trainer> trainers = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!"Tournament".equals(command)) {
            String[] input = command.split("\\s+");
            String trainerName = input[0];
            String name = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(name,element,health);

            trainers.putIfAbsent(trainerName,trainer);
            trainers.get(trainerName).addPokemon(pokemon);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)){
                    trainer.increseBadges(1);
                }else {
                    trainer.damegePokemons(10);
                }
            }

            command = scanner.nextLine();
        }
        trainers.entrySet().stream().sorted((f,s) -> s.getValue().getBadges() - f.getValue().getBadges())
                .forEach(entrty -> {
                    System.out.println(entrty.getValue().toString());
                });
    }
}
