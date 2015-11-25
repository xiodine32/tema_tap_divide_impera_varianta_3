# Tehnici Avansate de Programare

Tema 5 - Varianta 3

Cerinte
===

  1. Se dă un vector a=(a<sub>1</sub>,…a<sub>n</sub>) de tip munte (există un indice
  i astfel încât a<sub>1</sub>&lt;a<sub>2</sub>&lt;…&lt; a<sub>i</sub> &gt;a<sub>i</sub>+1&gt;…&gt;a<sub>n</sub>;
  a<sub>i</sub> se numește vârful muntelui).
  
     Propuneți un algoritm O(log n) care determină vârful muntelui (în calculul complexității algoritmului nu se
     consideră și citirea vectorului). __exc 1,cap. 5 (1p)__
     
  2. [http://www.infoarena.ro/problema/z](http://www.infoarena.ro/problema/z) (fără a memora tabla) __(2p)__
  
  3. Se consideră un vector cu n elemente. 
     
     Se numeşte inversiune semnificativă a vectorului o pereche perechi (i, j) cu proprietatea că i &lt;
     j şi a<sub>i</sub> &gt; 2*a<sub>j</sub>.
     
     Să de determine numărul de inversiuni semnificative din vector. 
     
     De exemplu, vectorul 4, 8, 11, 3, 5 are 3 inversiuni semnificative: (8,3), (11,3), (11,5) - 
     __O(n log n) exc. 2, cap. 5 (3p)__
     
  4. Se dau doi vectori a și b de lungime n, respectiv m, cu elementele ordonate crescător.
     
     Propuneţi un algoritm cât mai eficient pentru a determina mediana vectorului obținut prin interclasarea celor doi
     vectori. 
     
     Justificaţi complexitatea algoritmului propus. __(3p – O(log(min{n,m}))__
     
  5. Dată o mulţime de puncte în plan (prin coordonatele lor), să de determine cea mai apropiată pereche
     de puncte (se vor afişa distanţa şi punctele).
     
     [http://infoarena.ro/problema/cmap](http://infoarena.ro/problema/cmap) 
     __4p - O(n log n)__