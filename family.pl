 % Hechos.
es_enfermedad(anemia).
es_sintoma_de(apatia,anemia).
es_sintoma_de(cansancio,anemia).
es_sintoma_de(cansancio,gripe).
es_sintoma_de(cansancio,tuberculosis).
es_medicina_de(contrex,gripe).
es_sintoma_de(diarrea,hepatitis).
es_sintoma_de(diarrea,malaria).
es_sintoma_de(dolor_de_cabeza,gripe).
es_especialista_de(endocrinologo,hepatitis).
es_sintoma_de(escalofrios,malaria).
es_sintoma_de(escalofrios,tuberculosis).
es_sintoma_de(fiebre,gripe).
es_sintoma_de(fiebre,malaria).
es_sintoma_de(fiebre,rubeola).
es_sintoma_de(fiebre,tuberculosis).
es_enfermedad(gripe).
es_enfermedad(hepatitis).
es_sintoma_de(ictericia,hepatitis).
es_sintoma_de(ictericia,malaria).
es_sintoma_de(jaqueca,rubeola).
es_medicina_de(jarabe,gripe).
es_enfermedad(malaria).
es_especialista_de(medico_general,malaria).
es_especialista_de(medico_general,rubeola).
es_sintoma_de(nauseas,anemia).
es_sintoma_de(nauseas,hepatitis).
es_especialista_de(nutricionista,anemia).
es_especialista_de(nutricionista,tuberculosis).
es_especialista_de(otorrino,gripe).
es_medicina_de(pastillas,hepatitis).
es_medicina_de(pastillas,tuberculosis).
es_enfermedad(rubeola).
es_sintoma_de(secrecion,rubeola).
es_sintoma_de(tos,gripe).
es_sintoma_de(tos,tuberculosis).
es_enfermedad(tuberculosis).
es_medicina_de(vacuna,malaria).
es_medicina_de(vacuna,rubeola).
es_medicina_de(vitaminas,anemia).


% Reglas.
atiende_especialista(W,X):-es_sintoma_de(X,Y),es_especialista_de(W,Y).
es_receta_de(W,X):-es_sintoma_de(X,Y),es_medicina_de(W,Y).
