 % Hechos.
es_nena(angelina).
pega_a_(angelina,brunella).
es_nena(brunella).
es_nena(camila).
es_nena(esperanza).
es_nene(lucas).
pega_a_(lucas,mora).
es_nena(mora).


% Reglas.
es_amiga_de(X,Y):-es_nena(X),not(pega_a_(X,Y)).
es_amigo_de(X,Y):-es_nene(X),not(pega_a_(X,Y)).
