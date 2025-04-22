package HerancaEPolimorfismo.Animais;

public class AppTesteAnimal {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Cavalo cavalo = new Cavalo();
        Preguica preguica = new Preguica();
        Veterinario veterinario = new Veterinario();
        Zoologico zoologico = new Zoologico();

        cachorro.setNome("Chacorro");
        cachorro.setSom("Auauau");

        cavalo.setNome("Caballo");
        cavalo.setSom("Pocotopocoto");

        preguica.setNome("pregriça");
        preguica.setSom("ZZZ");


        System.out.println(cachorro.getSom());
        System.out.println(cavalo.getSom());
        System.out.println(preguica.getSom());

        veterinario.examinar(cachorro);
        veterinario.examinar(cavalo);
        veterinario.examinar(preguica);

        zoologico.animais[0] = cachorro;
        zoologico.animais[1] = cavalo;
        zoologico.animais[2] = preguica;
        zoologico.animais[3] = cachorro;
        zoologico.animais[4] = cavalo;
        zoologico.animais[5] = preguica;
        zoologico.animais[6] = cachorro;
        zoologico.animais[7] = cavalo;
        zoologico.animais[8] = preguica;
        zoologico.animais[9] = cachorro;

        for(int i = 0; i < 10; i++){
            System.out.println(zoologico.animais[i].getNome());
            System.out.println(zoologico.animais[i].getSom());
            System.out.println(zoologico.animais[i].getMoverse());
        }
    }
}
