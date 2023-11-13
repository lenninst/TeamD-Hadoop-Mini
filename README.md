# Framework Hadoop-Mini
Ingresa al directorio View y ejecuta el archivo hadoop-mini
El framework Hadoop-Mini simplifica el modelo de programación MapReduce, ofreciendo componentes clave:
## Como ejecutar

## Componentes

1. **Entrada:**
   Lee, divide y traduce el archivo de entrada en pares clave-valor para las funciones Map. Almacena las claves en un búfer intermedio.

2. **Nodo Map:**
   Ejecuta funciones Map personalizadas en pares clave-valor. Lee del búfer y almacena los resultados en el búfer de salida del nodo.

3. **Combinador (Opcional):**
   Combina opcionalmente la salida del nodo Map usando una función personalizable. Ejemplo: combinar (líneas,13) y (líneas,3) en (líneas,16).

4. **Particionador:**
   Decide a qué nodo Reduce debe ir un par clave-valor. Asegura que los pares con las mismas claves vayan al mismo nodo Reduce.

5. **Ordenado:**
   Agrupa los pares clave-valor en el búfer de entrada del nodo Reduce. Ejemplo: modificar (hola,3), (adiós,2), (hola,1) a (hola,[3,2]), (adiós,[2]).

6. **Nodo Reduce:**
   Ejecuta funciones Reduce personalizadas en pares clave-valor (clave, lista_de_valores) y almacena el resultado en un búfer de salida.

7. **Salida:**
   Escribe los pares clave-valor del búfer de salida del nodo Reduce en el archivo de salida.

8. **Tarea:**
   Orquesta componentes para tareas MapReduce. Configura parámetros y ejecuta la computación.

## Uso

Configura parámetros, archivos de entrada/salida y ejecuta tareas fácilmente con el framework Hadoop-Mini.

## Contribuciones

¡Agradecemos las contribuciones! Sigue nuestras [pautas de contribución](CONTRIBUTING.md).

## Licencia

Este proyecto está bajo [NOMBRE_DE_LA_LICENCIA]. Consulta [LICENSE.md](LICENSE.md) para más detalles.

## Contacto

Para consultas o comentarios, comunícate a por el grupo de whatsapp o abre un problema en GitHub.
