import androidx.compose.ui.graphics.Color

fun typeColor(type: String): Color {
    return when (type.lowercase()) {
        "normal" -> Color(0xFFA9A9A9) // Gris atténué
        "feu" -> Color(0xFFCD5C5C) // Rouge atténué
        "eau" -> Color(0xFF6495ED) // Bleu atténué
        "électrique" -> Color(0xFFFFD700) // Jaune atténué
        "plante" -> Color(0xFF32CD32) // Vert atténué
        "glace" -> Color(0xFF00FFFF) // Cyan atténué
        "combat" -> Color(0xFF696969) // Gris foncé atténué
        "poison" -> Color(0xFFDA70D6) // Magenta atténué
        "sol" -> Color(0xFF8B4513) // Marron
        "vol" -> Color(0xFFA9A9A9) // Gris clair atténué
        "psy" -> Color(0xFFFFB6C1) // Rose atténué
        "insecte" -> Color(0xFF228B22) // Vert foncé atténué
        "roche" -> Color(0xFF8B4513) // Brun
        "spectre" -> Color(0xFF8A2BE2) // Pourpre atténué
        "dragon" -> Color(0xFF4B0082) // Indigo atténué
        "ténèbres" -> Color(0xFF2F4F4F) // Noir atténué
        "acier" -> Color(0xFFC0C0C0) // Argent
        "féérique" -> Color(0xFFFFB6C1) // Rose clair atténué
        else -> Color.Black
    }
}
