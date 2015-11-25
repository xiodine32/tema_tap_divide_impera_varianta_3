# Tehnici Avansate de Programare

Tema 5 - Varianta 3

Cerinte
===

  1. Se dă un vector a=(a1,…an) de tip munte (există un indice i astfel încât a1<a2<…<ai > ai+1>…>an; ai
  se numește vârful muntelui).
  
     Propuneți un algoritm O(log n) care determină vârful muntelui (în calculul complexității algoritmului nu se
     consideră și citirea vectorului). __exc 1,cap. 5 (1p)__
     
  2. [http://www.infoarena.ro/problema/z](http://www.infoarena.ro/problema/z) (fără a memora tabla) __(2p)__
  
  3. Se consideră un vector cu n elemente. 
     
     Se numeşte inversiune semnificativă a vectorului o pereche perechi (i, j) cu proprietatea că i < j şi ai > 2*aj.
     
     
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