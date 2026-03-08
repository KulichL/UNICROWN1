UNICROWN

UNICROWN je textová adventura napsaná v jazyce Java.
Hráč se pohybuje mezi místnostmi, sbírá předměty, komunikuje s postavami a bojuje s nepřáteli.
Cílem hry je porazit krále Cicibuka a získat královskou korunu.

Hra využívá textové příkazy zadávané hráčem do konzole.

Herní mechaniky

Hra obsahuje několik základních mechanik:

Pohyb mezi místnostmi

Sbírání předmětů

Inventář

Používání předmětů

Komunikace s NPC

Soubojový systém

Speciální předměty (kouzelný prášek)

Pro poražení krále je nutné nejdříve použít kouzelný prášek, který ho oslabí.

Ovládání hry

Hráč ovládá hru pomocí následujících příkazů:

Příkaz	Popis
napoveda	zobrazí seznam všech příkazů
jdi <smer>	přesune hráče do jiné místnosti
seber <id/nazev>	vezme předmět z místnosti
inventar	zobrazí obsah inventáře
pouzij <id/nazev>	použije předmět z inventáře
mluv <jmeno>	promluví s postavou
utok <jmeno>	zaútočí na nepřítele
obrana	sníží poškození v příštím kole
konec	ukončí hru

Jak hru spustit

Hra je konzolová aplikace, proto je doporučeno ji spouštět z terminálu pomocí příkazu java -jar, nikoli dvojklikem na soubor .jar.

Naklonujte repozitář:

git clone https://github.com/KulichL/UNICROWN1

Otevřete projekt v IntelliJ IDEA nebo jiném Java IDE.

Spusťte třídu:

Main.java

Po spuštění se hra spustí v konzoli.

Použité technologie

Java

Maven

Gson – načítání světa ze souboru JSON

JUnit – unit testy

Struktura hry

Svět hry je načítán ze souboru:

world.json

Tento soubor obsahuje definici místností, jejich popis a propojení mezi nimi.
