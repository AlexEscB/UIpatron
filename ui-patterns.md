# UI Patterns (Patrones de Interfaz de Usuario)

Guía de estudio con explicación detallada, ejemplos de interfaz, ejemplos en código (React) y casos de aplicación.

---

## Índice

1. [¿Qué es un UI Pattern?](#1-qué-es-un-ui-pattern)
2. [Origen histórico](#2-origen-histórico)
3. [Anatomía de un patrón](#3-anatomía-de-un-patrón)
4. [Beneficios](#4-beneficios)
5. [Dónde se usan](#5-dónde-se-usan)
6. [Problemas de diseño que resuelven](#6-problemas-de-diseño-que-resuelven)
7. [Categorías de patrones](#7-categorías-de-patrones)
   - [7.1 Patrones de navegación](#71-patrones-de-navegación)
   - [7.2 Patrones de contenido y estructura](#72-patrones-de-contenido-y-estructura)
   - [7.3 Patrones de entrada de datos](#73-patrones-de-entrada-de-datos)
   - [7.4 Patrones de feedback y estado](#74-patrones-de-feedback-y-estado)
8. [Ejemplos en código](#8-ejemplos-en-código)
9. [Casos de aplicación reales](#9-casos-de-aplicación-reales)
10. [Dark Patterns](#10-dark-patterns-patrones-oscuros)
11. [Ética y normativa](#11-ética-y-normativa)
12. [Conclusiones](#12-conclusiones)

---

## 1. ¿Qué es un UI Pattern?

Un **UI Pattern** (patrón de interfaz de usuario) es una **solución de diseño reutilizable** para un problema que aparece una y otra vez en las interfaces.

### Lo que SÍ es

- Una **receta de diseño**: describe el problema, el contexto en el que aplica y cómo se resuelve.
- Una solución **probada** en muchos productos y con muchos usuarios.
- Algo que cada diseñador **adapta** a las necesidades de su producto.

### Lo que NO es

- **No es un componente terminado.** Un botón de una librería (Material UI, Bootstrap) es un *componente*; el patrón es la idea de *cuándo y cómo* usarlo.
- **No es una plantilla para copiar y pegar.** Dos apps pueden usar el mismo patrón (pestañas) y verse completamente distintas.

### Ejemplo para entender la diferencia

| Concepto | Ejemplo |
|---|---|
| **Problema** | El usuario necesita ver varias secciones del mismo nivel sin salir de la pantalla. |
| **Patrón** | Pestañas (*tabs*). |
| **Componente** | `<Tabs>` de Material UI, o un `<div role="tablist">` hecho a mano. |
| **Implementación** | El código concreto de tu proyecto. |

El patrón es la **idea**; el componente y la implementación son **una forma de materializarla**.

---

## 2. Origen histórico

1. **Arquitectura (años 70):** el arquitecto **Christopher Alexander** documentó soluciones repetibles para problemas de construcción y urbanismo en su obra *A Pattern Language*. Por ejemplo: "cómo debe ser una ventana para que una habitación se sienta acogedora".
2. **Programación:** la idea saltó a la ingeniería de software con los **patrones de diseño** (Gang of Four: Singleton, Observer, Command, etc.).
3. **Diseño de interfaces:** finalmente se aplicó a la UI para documentar soluciones recurrentes de navegación, formularios, listas, mensajes de error, etc.

> Idea clave: en los tres campos se parte de lo mismo: *"este problema ya se resolvió antes, no lo reinventes"*.

---

## 3. Anatomía de un patrón

Un patrón bien documentado suele tener estas partes:

| Parte | Pregunta que responde | Ejemplo con "Breadcrumbs" |
|---|---|---|
| **Nombre** | ¿Cómo lo llamamos? | Breadcrumbs (migas de pan) |
| **Problema** | ¿Qué dificultad resuelve? | El usuario se pierde en una jerarquía profunda de categorías. |
| **Contexto** | ¿Cuándo aplica? | Sitios con 3 o más niveles de profundidad (tiendas en línea, documentación). |
| **Solución** | ¿Cómo se resuelve? | Mostrar la ruta `Inicio > Categoría > Producto`, con cada nivel clicable. |
| **Consecuencias** | ¿Qué ventajas y costos tiene? | Orienta y permite volver atrás; ocupa espacio y no sirve en sitios planos. |
| **Ejemplos** | ¿Dónde se ve? | Amazon, MercadoLibre, documentación técnica. |

---

## 4. Beneficios

### 4.1 Consistencia
El usuario no tiene que **aprender de nuevo** a usar algo en cada producto. Si el ícono de tres líneas abre un menú en una app, lo hará en todas.

*Ejemplo:* un usuario que sabe usar el carrito de compras en una tienda sabe usarlo en cualquier otra, porque todas lo ubican arriba a la derecha con un ícono de carrito.

### 4.2 Usabilidad
Son soluciones **ya probadas con usuarios reales**, por lo que reducen errores y confusión.

*Ejemplo:* el selector de fecha evita que el usuario escriba `31/02/2026` o confunda `MM/DD` con `DD/MM`.

### 4.3 Velocidad
El equipo **no empieza de cero** y toma decisiones más rápido. En lugar de debatir cómo mostrar una lista de productos, se elige entre "grilla" o "lista" según el caso.

### 4.4 Comunicación
Diseñadores, desarrolladores y clientes comparten un **vocabulario común**. Decir *"necesitamos un skeleton screen mientras carga el feed"* evita media hora de explicaciones.

### 4.5 Accesibilidad
Muchos patrones ya incluyen **buenas prácticas** para distintos tipos de usuarios (lectores de pantalla, navegación por teclado, contraste). Por ejemplo, el patrón *tabs* define roles ARIA (`tablist`, `tab`, `aria-selected`).

---

## 5. Dónde se usan

| Medio | Patrones típicos |
|---|---|
| **Aplicaciones móviles** | Bottom nav, menú hamburguesa, pull-to-refresh, toasts |
| **Sitios web** | Breadcrumbs, paginación, acordeones, buscador |
| **Software de escritorio** | Barras de menú, sidebar, diálogos de confirmación, deshacer |
| **Videojuegos** | Barras de progreso/vida, menús de pausa, tooltips, badges de notificación |
| **Kioscos de autoservicio** | Formularios por pasos (wizard), botones grandes, confirmaciones |
| **Cajeros automáticos** | Wizard (elegir operación → monto → confirmar), confirmaciones antes de acciones irreversibles |
| **Electrodomésticos con pantalla** | Listas simples, toggles, estados de botones, feedback inmediato |

---

## 6. Problemas de diseño que resuelven

Son situaciones que se repiten en casi cualquier producto.

### 6.1 Problemas desde la perspectiva del usuario

| Problema | Descripción | Patrones que ayudan |
|---|---|---|
| **Desorientación** | El usuario no sabe dónde está ni qué hacer después. | Breadcrumbs, tabs, sidebar, barra de progreso |
| **Fricción y errores** | Fallos al ingresar datos en formularios confusos. | Validación en línea, selectores, autocompletado, wizard |
| **Saturación** | Exceso de información en una sola pantalla. | Acordeón, tarjetas, paginación, divulgación progresiva |
| **Incertidumbre** | No saber si el sistema está cargando o si falló. | Spinners, skeletons, toasts, mensajes de error |

### 6.2 Preguntas de diseño típicas

| Pregunta | Categoría de patrón |
|---|---|
| ¿Cómo evito que el usuario se pierda? | Navegación |
| ¿Cómo muestro mucha información sin abrumar? | Contenido y estructura |
| ¿Cómo recojo datos sin que se equivoque? | Entrada de datos |
| ¿Cómo le aviso que su acción funcionó (o falló)? | Feedback y estado |
| ¿Cómo hago que el cambio entre pantallas se entienda? | Navegación + feedback |
| ¿Qué pasa cuando algo sale mal o no hay datos? | Feedback y estado (mensajes de error, *empty states*) |

---

## 7. Categorías de patrones

## 7.1 Patrones de navegación

> **Objetivo:** ayudar al usuario a moverse por la interfaz, saber dónde está y a dónde puede ir.

### Menú hamburguesa
- **Qué es:** esconde las opciones de navegación detrás de un ícono de tres líneas (☰).
- **Cuándo usarlo:** pantallas pequeñas, o cuando hay muchas opciones secundarias.
- **Ventaja:** ahorra espacio.
- **Riesgo:** **oculta opciones importantes**; lo que no se ve, se usa menos.
- **Ejemplo:** menú principal de la mayoría de sitios en móvil.

```text
┌──────────────────────┐
│ ☰   Mi Tienda    🛒  │
├──────────────────────┤
│   (contenido)        │
└──────────────────────┘
```

### Barra de navegación inferior (bottom nav)
- **Qué es:** 3 a 5 destinos principales siempre visibles en la parte baja de la pantalla.
- **Cuándo usarlo:** apps móviles con pocas secciones de igual importancia.
- **Ventaja:** accesible con el pulgar, siempre visible.
- **Riesgo:** más de 5 destinos la vuelve incómoda.
- **Ejemplos:** Instagram, Spotify.

```text
┌──────────────────────┐
│   (contenido)        │
├──────────────────────┤
│ 🏠    🔍    ➕    👤  │
│ Inicio Buscar Crear Perfil │
└──────────────────────┘
```

### Pestañas (tabs)
- **Qué es:** dividen el contenido en secciones **del mismo nivel**.
- **Ventaja:** se cambia de sección **sin salir de la pantalla**.
- **Ejemplo:** perfil de usuario con `Resumen | Métricas | Ajustes`.

```text
[ Resumen ] [ Métricas ] [ Ajustes ]
─────────────────────────────────────
  Contenido de la pestaña activa
```

### Breadcrumbs (migas de pan)
- **Qué es:** muestran la ruta recorrida y permiten volver atrás.
- **Cuándo usarlo:** jerarquías profundas (tiendas en línea, documentación).
- **Ejemplo:**

```text
Inicio > Electrónica > Celulares > Modelo X
```

### Barra lateral (sidebar)
- **Qué es:** menú fijo a un costado de la pantalla.
- **Cuándo usarlo:** paneles de administración, herramientas con muchas secciones.
- **Ejemplo:** Gmail (Recibidos, Enviados, Borradores…).

### Paginación y scroll infinito
Dos formas de recorrer listas largas:

| | Paginación | Scroll infinito |
|---|---|---|
| **Idea** | Dividir en páginas numeradas `1 2 3 … 10` | Cargar más contenido al llegar al final |
| **Ventaja** | **Control**: el usuario sabe cuánto hay y puede volver a un punto | **Fluidez**: no hay interrupciones |
| **Desventaja** | Requiere clics extra | Difícil llegar al pie de página o volver a un elemento |
| **Úsalo en** | Resultados de búsqueda, tablas, tiendas | Redes sociales, feeds |

### Buscador
- **Qué es:** atajo cuando hay demasiado contenido para navegar manualmente.
- **Buenas prácticas:** ubicarlo arriba, con ícono de lupa, y combinarlo con **autocompletado**.

---

## 7.2 Patrones de contenido y estructura

> **Objetivo:** organizar la información para que sea fácil de escanear y entender.

### Tarjetas (cards)
- **Qué son:** agrupan una **unidad de información** (imagen, título, descripción, acción).
- **Ejemplos:** Pinterest, tiendas, sitios de noticias.

```text
┌────────────────┐
│   [ imagen ]   │
│ Título         │
│ Descripción    │
│ [ Comprar ]    │
└────────────────┘
```

### Listas
- **Qué son:** elementos en secuencia vertical.
- **Úsalas para:** contenido comparable (contactos, mensajes, configuraciones).

### Grilla (grid)
- **Qué es:** reparte elementos en filas y columnas.
- **Ideal para:** contenido visual (galerías, catálogo de productos).
- **Lista vs. grilla:** la lista favorece leer detalles; la grilla favorece comparar visualmente.

### Acordeón
- **Qué es:** secciones que se **expanden y colapsan**.
- **Ejemplo típico:** preguntas frecuentes (FAQ).
- **Ventaja:** reduce la saturación mostrando solo lo que el usuario pide.

```text
▶ ¿Cómo cambio mi contraseña?
▼ ¿Cómo cancelo mi suscripción?
   Ve a Ajustes > Suscripción > Cancelar.
▶ ¿Cómo contacto a soporte?
```

### Carrusel
- **Qué es:** muestra varios elementos en un espacio pequeño que se desliza.
- **Útil para:** destacados.
- **Advertencia:** **mucha gente no ve los últimos elementos**. No pongas ahí contenido crítico.

### Tablas
- **Para qué:** datos que se **comparan por filas y columnas** (precios, estadísticas, planes).

### Jerarquía visual
- **Qué es:** usar **tamaño, color, contraste y espacio** para que lo importante se vea primero.
- **Ejemplo:** el botón principal ("Comprar") grande y de color fuerte; el secundario ("Cancelar") pequeño y gris.

### Cabecera + contenido + pie (layout)
- **Qué es:** la estructura básica de casi toda página web.
- **Cabecera:** logo, navegación, buscador.
- **Contenido:** lo que el usuario vino a hacer o ver.
- **Pie:** enlaces legales, contacto, redes.

### Divulgación progresiva (Progressive Disclosure)
Patrón transversal que aparece en el ejemplo en código: **mostrar primero lo esencial y revelar lo avanzado solo cuando el usuario lo pide**. Se implementa con acordeones, botones "Ver más", paneles de configuración avanzada, etc.

---

## 7.3 Patrones de entrada de datos

> **Objetivo:** que el usuario le dé información al sistema de forma clara y con pocos errores.

| Patrón | Descripción | Ejemplo |
|---|---|---|
| **Campos de texto (inputs)** | Texto libre, con **etiqueta clara** y **ejemplo** (placeholder). | Nombre, correo |
| **Radio buttons** | Escoger **una sola** opción entre varias **visibles**. | Método de pago: ○ Tarjeta ○ PSE ○ Efectivo |
| **Checkboxes** | Escoger **una o varias** opciones. | ☑ Acepto términos ☐ Recibir novedades |
| **Lista desplegable (dropdown)** | Muchas opciones en poco espacio. | País, ciudad |
| **Slider** | Escoger un valor dentro de un **rango**. | Volumen, rango de precio |
| **Interruptor (toggle)** | Activar o desactivar algo (efecto inmediato). | Modo oscuro |
| **Autocompletado** | Sugiere mientras escribes. | Buscadores, direcciones |
| **Selector de fecha/hora** | Evita errores de formato. | Reserva de vuelos o citas |
| **Validación en línea** | Avisa del error **mientras** se completa el campo, no al final. | "Correo inválido" al salir del campo |
| **Formulario por pasos (wizard)** | Divide un formulario largo en etapas con barra de progreso. | Registro en 3 pasos, cajeros automáticos |

### Reglas prácticas

- **Radio vs. checkbox:** ¿una sola opción? → radio. ¿Varias? → checkbox.
- **Radio vs. dropdown:** pocas opciones (≤ 5) → radio (todas visibles). Muchas → dropdown.
- **Checkbox vs. toggle:** el toggle aplica **al instante**; el checkbox suele esperar a que se envíe el formulario.
- **Placeholder no reemplaza a la etiqueta:** desaparece al escribir y puede confundir.

### Patrones de entrada "tolerantes"

- **Forgiving Format:** aceptar el dato en **cualquier formato razonable** y normalizarlo por dentro (`300 123 4567`, `3001234567`, `+57 300-123-4567` son equivalentes).
- **Lazy Registration:** **no pedir cuenta hasta que sea realmente necesario** (por ejemplo, al guardar), conservando el avance del usuario.

---

## 7.4 Patrones de feedback y estado

> **Objetivo:** informar al usuario qué está pasando y si su acción funcionó.
> **Regla de oro:** el sistema **siempre** debe responder a una acción del usuario, y **rápido**.

| Patrón | Descripción | Ejemplo |
|---|---|---|
| **Indicadores de carga (spinners)** | Avisan que algo está en proceso, **sin decir cuánto falta**. | Círculo girando al iniciar sesión |
| **Barras de progreso** | Muestran **cuánto falta**. | Descargas, formularios por pasos |
| **Skeleton screens** | Silueta gris del contenido mientras carga; la espera se siente más corta. | Feed de YouTube o LinkedIn |
| **Toast / snackbar** | Mensaje breve y temporal. | "Guardado" |
| **Mensajes de éxito y error** | Confirman que salió bien o **explican qué falló y cómo solucionarlo**. | "La contraseña debe tener 8 caracteres" |
| **Insignias (badges)** | El numerito rojo que indica pendientes. | 🔔 con un 3 |
| **Estados de los botones** | normal, hover, presionado, deshabilitado, cargando. | Botón "Guardando…" bloqueado |
| **Confirmaciones** | Diálogos antes de acciones **irreversibles**. | "¿Seguro que quieres eliminar?" |
| **Deshacer (undo)** | Revertir una acción **sin pedir confirmación**. | "Mensaje eliminado. **Deshacer**" |

### Confirmación vs. deshacer

| | Confirmación | Deshacer |
|---|---|---|
| **Cuándo** | Antes de la acción | Después de la acción |
| **Costo para el usuario** | Un clic extra **siempre** | Solo si se arrepiente |
| **Úsalo cuando** | La acción es realmente irreversible (borrar cuenta) | La acción es reversible (archivar, borrar un correo) |

Abusar de las confirmaciones hace que el usuario haga clic en "Aceptar" sin leer.

### Spinner vs. barra de progreso vs. skeleton

- **No sé cuánto va a tardar** → spinner.
- **Sé cuánto falta** → barra de progreso.
- **Estoy cargando una pantalla con estructura conocida** → skeleton.

### Buenos mensajes de error

Un buen mensaje responde: **¿qué pasó? ¿por qué? ¿cómo lo soluciono?**

```text
❌ Mal:   "Error 500"
❌ Mal:   "Datos inválidos"
✅ Bien:  "No pudimos guardar tus cambios porque perdiste la conexión.
           Revisa tu internet e inténtalo de nuevo."
```

---

## 8. Ejemplos en código

Los siguientes ejemplos usan **React** (Hooks) y muestran cómo cada categoría de patrón se traduce en código.

### 8.1 Navegación: Tabs + Breadcrumb sincronizados

```jsx
import { useState } from 'react';

export function PanelNavegacion() {
  const [pestanaActiva, setPestanaActiva] = useState('Resumen');
  const secciones = ['Resumen', 'Métricas', 'Ajustes'];

  return (
    <header>
      {/* Breadcrumb: indica la ubicación exacta del usuario */}
      <nav aria-label="Breadcrumb">
        Inicio / Proyecto / <strong>{pestanaActiva}</strong>
      </nav>

      {/* Barra de Pestañas (Tabs): navegación sin recargar */}
      <div role="tablist">
        {secciones.map((item) => (
          <button
            key={item}
            role="tab"
            aria-selected={pestanaActiva === item}
            onClick={() => setPestanaActiva(item)}
          >
            {item}
          </button>
        ))}
      </div>
    </header>
  );
}
```

**Explicación**

1. `pestanaActiva` es una **variable de estado** que controla en qué sección está el usuario.
2. Al hacer clic en una pestaña, `setPestanaActiva(item)` actualiza el estado.
3. React vuelve a renderizar y **se sincronizan automáticamente** el breadcrumb (arriba) y el botón activo (`aria-selected`), **sin recargar la página**.
4. `aria-label`, `role="tablist"` y `aria-selected` aportan **accesibilidad** para lectores de pantalla.

**Patrones que combina:** Tabs + Breadcrumbs.

---

### 8.2 Contenido y estructura: Progressive Disclosure + Acordeón

```jsx
import { useState } from 'react';

export function TarjetaServidor({ servidor }) {
  // Oculta los detalles complejos por defecto
  const [verAvanzado, setVerAvanzado] = useState(false);

  return (
    <article className="card">
      {/* Jerarquía visual: lo importante se ve primero */}
      <h3>{servidor.nombre} · Estado: Activo</h3>

      {/* Acordeón: despliega contenido bajo demanda */}
      <button
        aria-expanded={verAvanzado}
        onClick={() => setVerAvanzado(!verAvanzado)}
      >
        {verAvanzado ? 'Ocultar red' : 'Ver detalles de red'}
      </button>

      {verAvanzado && (
        <div className="panel-oculto">
          <p>IP: {servidor.ip} | RAM: {servidor.ram}</p>
        </div>
      )}
    </article>
  );
}
```

**Explicación**

1. `verAvanzado` empieza en `false`: los datos técnicos **no se muestran** al inicio.
2. El título (nombre y estado) es lo importante y se ve de inmediato → **jerarquía visual**.
3. La **evaluación de cortocircuito** `verAvanzado && (...)` evita renderizar la IP y la RAM hasta que el usuario lo pide explícitamente.
4. `aria-expanded` informa a los lectores de pantalla si el panel está abierto o cerrado.

**Patrones que combina:** Tarjeta + Jerarquía visual + Acordeón + Progressive Disclosure.

---

### 8.3 Entrada de datos: Forgiving Format + Lazy Registration

```jsx
import { useState } from 'react';

export function FormularioReserva({ usuarioActivo }) {
  const [telefono, setTelefono] = useState('');
  const [pedirRegistro, setPedirRegistro] = useState(false);

  // Forgiving Format: filtra espacios, guiones y prefijo +57
  const limpiarTelefono = (val) =>
    val.replace(/^\+57/, '').replace(/\D/g, '');

  const guardar = (e) => {
    e.preventDefault();
    const payload = { tel: limpiarTelefono(telefono) };

    // Lazy Registration: pide cuenta recién al guardar
    if (!usuarioActivo) {
      localStorage.setItem('borrador', JSON.stringify(payload));
      setPedirRegistro(true);
      return;
    }
    enviarAlServidor(payload);
  };

  return (
    <form onSubmit={guardar}>
      <label htmlFor="tel">Teléfono</label>
      <input
        id="tel"
        value={telefono}
        onChange={(e) => setTelefono(e.target.value)}
        placeholder="Ej: +57 300 123 4567"
      />
      <button type="submit">Reservar</button>
      {pedirRegistro && <p>Crea tu cuenta para terminar la reserva.</p>}
    </form>
  );
}
```

**Explicación**

1. `limpiarTelefono()` aplica **Forgiving Format**: quita símbolos **sin lanzar errores**. El usuario puede escribir como quiera.
2. La expresión regular `/\D/g` significa "cualquier carácter que **no** sea dígito" (`\D`), en **todo** el texto (`g` = global). Así `300-123 4567` → `3001234567`.
3. `/^\+57/` elimina el prefijo `+57` solo si está **al inicio** (`^`).
4. **Lazy Registration:** el sistema no obliga a registrarse antes de llenar el formulario. Si no hay sesión, el avance se guarda en `localStorage` y **solo entonces** se pide el registro; así no se pierde lo que el usuario ya escribió.

**Patrones que combina:** Campo de texto con etiqueta y placeholder + Forgiving Format + Lazy Registration.

---

### 8.4 Feedback y estado: Completeness Meter + máquina de estados + Toast

```jsx
import { useState } from 'react';

export function EstadoPerfil({ perfil }) {
  const [estado, setEstado] = useState('inactivo'); // inactivo | cargando | exito

  // Completeness Meter: calcula el % de campos llenos
  const campos = [perfil.nombre, perfil.correo, perfil.rol];
  const llenos = campos.filter(Boolean).length;
  const porcentaje = Math.round((llenos / campos.length) * 100);

  return (
    <section>
      <progress value={porcentaje} max="100" />
      <span>Completitud del perfil: {porcentaje}%</span>

      <button disabled={estado === 'cargando'}>
        {estado === 'cargando' ? 'Guardando...' : 'Guardar'}
      </button>

      {estado === 'exito' && (
        <div role="status" className="toast">Cambios guardados</div>
      )}
    </section>
  );
}
```

**Explicación**

1. `campos.filter(Boolean)` descarta los valores "falsos" (`''`, `null`, `undefined`) y `.length` cuenta cuántos campos **sí están llenos**.
2. `porcentaje = llenos / total × 100` alimenta la **barra de progreso** (`<progress>`), el *Completeness Meter*.
3. `estado` funciona como una **máquina de estados**: `inactivo → cargando → exito`.
   - En `cargando`: el botón se **deshabilita** (evita doble envío) y cambia su texto.
   - En `exito`: aparece el **toast** "Cambios guardados".
4. `role="status"` hace que los lectores de pantalla anuncien el mensaje sin interrumpir.

> Nota: en un caso real, `setEstado('cargando')` se llamaría al enviar y `setEstado('exito')` al recibir la respuesta del servidor.

**Patrones que combinan:** Barra de progreso + Estados del botón + Toast + Mensaje de éxito.

---

## 9. Casos de aplicación reales

### Caso 1: Tienda en línea

| Pantalla | Problema | Patrón |
|---|---|---|
| Home | Mostrar muchos productos | Grilla + tarjetas |
| Categorías | No perderse | Breadcrumbs + sidebar de filtros |
| Resultados | Listas largas | Paginación |
| Búsqueda | Encontrar rápido | Buscador + autocompletado |
| Checkout | Formulario largo | Wizard + validación en línea |
| Pago | Evitar errores | Selector de método (radio buttons) |
| Compra hecha | Confirmar | Mensaje de éxito + toast |

### Caso 2: App móvil de música

| Elemento | Patrón |
|---|---|
| Secciones principales (Inicio, Buscar, Biblioteca) | Bottom nav |
| Playlists | Lista + tarjetas |
| Cargando canciones | Skeleton screens |
| Descarga de álbum | Barra de progreso |
| Modo sin conexión | Toggle |
| Notificaciones | Badge |

### Caso 3: Cajero automático

| Paso | Patrón |
|---|---|
| Elegir operación | Lista de botones grandes |
| Ingresar monto | Campo numérico + validación |
| Resumen | Confirmación antes de la acción irreversible |
| Retiro en proceso | Spinner |
| Resultado | Mensaje de éxito o error claro |

El proceso completo es un **wizard** con pasos secuenciales.

### Caso 4: Panel de administración

| Elemento | Patrón |
|---|---|
| Menú de secciones | Sidebar |
| Datos de usuarios | Tablas |
| Detalles de un usuario | Tabs + acordeón |
| Eliminar un registro | Confirmación |
| Archivar un registro | Toast con **Deshacer** |

### Caso 5: Mini-ejercicio para practicar

Elige una app que uses a diario y completa:

1. ¿Qué **patrón de navegación** usa?
2. ¿Qué **patrón de entrada de datos** encuentras en su formulario de registro?
3. ¿Qué **feedback** recibes al realizar una acción?
4. ¿Hay algún **dark pattern**? (ver sección siguiente).

---

## 10. Dark Patterns (patrones oscuros)

Son **interfaces diseñadas intencionalmente para manipular, confundir o engañar al usuario**, aprovechando **sesgos cognitivos**. El término fue acuñado por **Harry Brignull**.

> Un UI pattern **ayuda** al usuario a lograr su objetivo. Un dark pattern **lo desvía** hacia el objetivo del negocio.

### 10.1 Roach Motel (trampa)
- **Cómo funciona:** suscribirse toma **un solo clic**, pero cancelar exige **llamadas telefónicas o menús ocultos**.
- **Ejemplo:** una suscripción que se activa en la web pero solo se cancela por llamada en horario de oficina.
- **Alternativa ética:** cancelar tan fácil como suscribirse (mismo número de pasos y mismo canal).

### 10.2 Confirmshaming
- **Cómo funciona:** botones de rechazo que **inducen culpa**.
- **Ejemplo:**

```text
[ ¡Sí, quiero ahorrar! ]
[ No gracias, prefiero gastar dinero de más ]
```

- **Alternativa ética:** botones neutros: `Aceptar` / `No, gracias`.

### 10.3 Drip Pricing (costos ocultos)
- **Cómo funciona:** mostrar un **precio inicial bajo** y agregar **cargos obligatorios** en el último paso del pago.
- **Ejemplo:** boleto a $50.000 que termina en $78.000 por "tarifa de servicio", "cargo administrativo", etc.
- **Alternativa ética:** mostrar el **precio total** desde el principio.

### 10.4 Misdirection (desvío visual)
- **Cómo funciona:** usar la jerarquía visual para dirigir la atención hacia lo que conviene al negocio y esconder la opción contraria.
- **Ejemplo:** botón "Aceptar compartir mis datos" grande y de color vivo; la opción de rechazo es un enlace diminuto y gris.
- **Alternativa ética:** ambas opciones con **el mismo peso visual**.

### Cómo detectarlos (lista rápida)

- ¿Es más fácil **aceptar** que **rechazar**?
- ¿Es más fácil **entrar** que **salir**?
- ¿Hay textos que me **hacen sentir culpable**?
- ¿El precio final **coincide** con el inicial?
- ¿Las opciones tienen **el mismo peso visual**?

---

## 11. Ética y normativa

### Autonomía del usuario
Quien diseña la interfaz controla la **arquitectura de decisiones** (qué se ve, qué se esconde, qué es fácil y qué es difícil). Manipularla **vulnera la libertad del usuario**.

### Confianza y retención
Los patrones oscuros **destruyen la reputación** del software y hacen que el usuario **no regrese**. Pueden aumentar conversiones a corto plazo, pero dañan la relación a largo plazo.

### Normativa legal
Leyes y regulaciones como:

- **GDPR** (Unión Europea): protección de datos y consentimiento libre e informado.
- **DSA** (Digital Services Act, UE): prohíbe diseños que engañen o manipulen.
- **FTC** (Estados Unidos): sanciona prácticas engañosas, como suscripciones difíciles de cancelar.

**multan interfaces donde cancelar o rechazar sea más complejo que aceptar.**

---

## 12. Conclusiones

1. **Los UI Patterns resuelven problemas reales** de navegación, estructura, captura de datos y estado del sistema.
2. **El buen desarrollo traslada la complejidad al código para hacerle la tarea más simple al humano.** Ejemplos vistos: `limpiarTelefono()` absorbe la variedad de formatos; `verAvanzado` esconde lo técnico; `estado` bloquea el botón y avisa del éxito.
3. **Dominar la psicología de las interfaces conlleva el deber ético de diseñar con transparencia.** El mismo conocimiento que permite ayudar al usuario permite manipularlo; la responsabilidad está en quien diseña.

### Resumen en una tabla

| Categoría | Pregunta que responde | Patrones clave |
|---|---|---|
| Navegación | ¿Dónde estoy y a dónde voy? | Tabs, breadcrumbs, bottom nav, sidebar, paginación |
| Contenido y estructura | ¿Cómo organizo la información? | Cards, grid, acordeón, jerarquía visual, layout |
| Entrada de datos | ¿Cómo recojo datos sin errores? | Inputs, radio, checkbox, selectores, validación, wizard |
| Feedback y estado | ¿Qué está pasando? ¿Funcionó mi acción? | Spinner, progreso, skeleton, toast, confirmación, undo |

---

## Referencias sugeridas

- Christopher Alexander, *A Pattern Language* (1977).
- Jenifer Tidwell, *Designing Interfaces* (patrones de UI).
- Harry Brignull, *Deceptive Patterns* (deceptive.design).
- Documentación de accesibilidad: WAI-ARIA Authoring Practices (w3.org).
- Material Design y Apple Human Interface Guidelines (guías de componentes y patrones).
