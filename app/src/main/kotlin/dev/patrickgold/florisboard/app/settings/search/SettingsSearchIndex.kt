/*
 * Copyright (C) 2026 DevEmperor (Dictate)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.patrickgold.florisboard.app.settings.search

import androidx.annotation.StringRes
import dev.patrickgold.florisboard.R
import dev.patrickgold.florisboard.app.Routes

/**
 * One searchable settings entry (issue #187). Because settings screens are plain composables with no
 * declarative registry, this index is hand-authored: each entry maps a localized [titleRes] (and an
 * optional [keywordsRes] of extra, comma-separated search terms) to the [route] that shows it, tagged
 * with the parent [sectionRes] for grouping in the results.
 *
 * If [anchor] is set and the destination screen tags the matching row with
 * [Modifier.settingsSearchAnchor], opening the result scrolls to and briefly highlights that exact row;
 * otherwise it simply lands on the screen.
 *
 * MAINTENANCE: whenever a new settings screen or a notable preference is added, add a corresponding
 * entry here (and, for row-level precision, wire `Modifier.settingsSearchAnchor("<anchor>")` on the row)
 * — the search only knows about what is listed in [SettingsSearchIndex.entries].
 */
data class SettingsSearchEntry(
    @StringRes val titleRes: Int,
    @StringRes val sectionRes: Int,
    val route: Any,
    @StringRes val keywordsRes: Int? = null,
    val anchor: String? = null,
)

object SettingsSearchIndex {
    // Section title resources reused for grouping (each is also the destination screen's own title).
    private const val S_DICTATE = R.string.dictate__title
    private const val S_REWORDING = R.string.dictate__rewording_title
    private const val S_PROVIDERS = R.string.dictate__providers_title
    private const val S_FLOATING = R.string.dictate__floating_button_title
    private const val S_LOCALIZATION = R.string.settings__localization__title
    private const val S_THEME = R.string.settings__theme__title
    private const val S_KEYBOARD = R.string.settings__keyboard__title
    private const val S_SMARTBAR = R.string.settings__smartbar__title
    private const val S_TYPING = R.string.settings__typing__title
    private const val S_GESTURES = R.string.settings__gestures__title
    private const val S_CLIPBOARD = R.string.settings__clipboard__title
    private const val S_MEDIA = R.string.settings__media__title
    private const val S_DICTIONARY = R.string.settings__dictionary__title
    private const val S_OTHER = R.string.settings__other__title
    private const val S_ABOUT = R.string.about__title

    val entries: List<SettingsSearchEntry> = buildList {
        // ---- Top-level screens (always navigable; land at the screen top) --------------------------
        add(SettingsSearchEntry(R.string.dictate__title, S_DICTATE, Routes.Settings.Dictate))
        add(SettingsSearchEntry(R.string.settings__localization__title, S_LOCALIZATION, Routes.Settings.Localization))
        add(SettingsSearchEntry(R.string.settings__theme__title, S_THEME, Routes.Settings.Theme))
        add(SettingsSearchEntry(R.string.settings__keyboard__title, S_KEYBOARD, Routes.Settings.Keyboard))
        add(SettingsSearchEntry(R.string.settings__smartbar__title, S_SMARTBAR, Routes.Settings.Smartbar))
        add(SettingsSearchEntry(R.string.settings__typing__title, S_TYPING, Routes.Settings.Typing))
        add(SettingsSearchEntry(R.string.settings__gestures__title, S_GESTURES, Routes.Settings.Gestures))
        add(SettingsSearchEntry(R.string.settings__clipboard__title, S_CLIPBOARD, Routes.Settings.Clipboard))
        add(SettingsSearchEntry(R.string.settings__media__title, S_MEDIA, Routes.Settings.Media))
        add(SettingsSearchEntry(R.string.settings__dictionary__title, S_DICTIONARY, Routes.Settings.Dictionary))
        add(SettingsSearchEntry(R.string.settings__other__title, S_OTHER, Routes.Settings.Other))
        add(SettingsSearchEntry(R.string.about__title, S_ABOUT, Routes.Settings.About))
        add(SettingsSearchEntry(R.string.physical_keyboard__title, S_OTHER, Routes.Settings.PhysicalKeyboard))
        add(SettingsSearchEntry(R.string.backup_and_restore__back_up__title, S_OTHER, Routes.Settings.Backup))
        add(SettingsSearchEntry(R.string.backup_and_restore__restore__title, S_OTHER, Routes.Settings.Restore))

        // ---- Dictate sub-screens -------------------------------------------------------------------
        add(SettingsSearchEntry(R.string.dictate__stats_title, S_DICTATE, Routes.Settings.DictateStats))
        add(SettingsSearchEntry(R.string.dictate__history_title, S_DICTATE, Routes.Settings.DictateHistory))
        add(SettingsSearchEntry(R.string.dictate__providers_title, S_PROVIDERS, Routes.Settings.DictateProviders))
        add(SettingsSearchEntry(R.string.dictate__languages_title, S_DICTATE, Routes.Settings.DictateLanguages))
        add(SettingsSearchEntry(R.string.dictate__mappings_title, S_DICTATE, Routes.Settings.DictateMappings))
        add(SettingsSearchEntry(R.string.dictate__proxy_title, S_PROVIDERS, Routes.Settings.DictateProxy))
        add(SettingsSearchEntry(R.string.dictate__wear_title, S_DICTATE, Routes.Settings.DictateWear))
        add(SettingsSearchEntry(R.string.dictate__formatting_title, S_DICTATE, Routes.Settings.DictateFormatting))
        add(SettingsSearchEntry(R.string.dictate__prompts_title, S_REWORDING, Routes.Settings.DictatePrompts()))
        add(SettingsSearchEntry(R.string.dictate__prompt_library_title, S_REWORDING, Routes.Settings.DictatePromptLibrary))

        // ---- Dictate main screen: individual rows (anchored) ---------------------------------------
        add(SettingsSearchEntry(R.string.dictate__realtime_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__realtime_title"))
        add(SettingsSearchEntry(R.string.dictate__longform_title, S_DICTATE, Routes.Settings.Dictate))
        add(SettingsSearchEntry(R.string.dictate__audio_focus_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__audio_focus_title"))
        add(SettingsSearchEntry(R.string.dictate__bluetooth_mic_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__bluetooth_mic_title"))
        add(SettingsSearchEntry(R.string.dictate__audio_source_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__audio_source_title"))
        add(SettingsSearchEntry(R.string.dictate__keep_screen_awake_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__keep_screen_awake_title"))
        add(SettingsSearchEntry(R.string.dictate__skip_silent_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__skip_silent_title"))
        add(SettingsSearchEntry(R.string.dictate__instant_recording_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__instant_recording_title"))
        add(SettingsSearchEntry(R.string.dictate__legacy_layout_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__legacy_layout_title"))
        add(SettingsSearchEntry(R.string.dictate__auto_enter_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__auto_enter_title"))
        add(SettingsSearchEntry(R.string.dictate__instant_output_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__instant_output_title"))
        add(SettingsSearchEntry(R.string.dictate__output_speed_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__output_speed_title"))
        add(SettingsSearchEntry(R.string.dictate__haptic_feedback_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__haptic_feedback_title"))
        add(SettingsSearchEntry(R.string.dictate__remember_last_dictation_title, S_DICTATE, Routes.Settings.Dictate, anchor = "dictate__remember_last_dictation_title"))
        add(SettingsSearchEntry(R.string.dictate__style_prompt_title, S_DICTATE, Routes.Settings.Dictate))
        add(SettingsSearchEntry(R.string.dictate__custom_words_title, S_DICTATE, Routes.Settings.Dictate))

        // ---- Rewording (AI) rows (anchored) --------------------------------------------------------
        add(SettingsSearchEntry(R.string.dictate__rewording_enabled_title, S_REWORDING, Routes.Settings.DictateRewording, anchor = "dictate__rewording_enabled_title"))
        add(SettingsSearchEntry(R.string.dictate__prompts_layout_title, S_REWORDING, Routes.Settings.DictateRewording, anchor = "dictate__prompts_layout_title"))
        add(SettingsSearchEntry(R.string.dictate__auto_formatting_title, S_REWORDING, Routes.Settings.DictateRewording, anchor = "dictate__auto_formatting_title"))
        add(SettingsSearchEntry(R.string.dictate__reasoning_effort_title, S_REWORDING, Routes.Settings.DictateRewording, anchor = "dictate__reasoning_effort_title"))
        add(SettingsSearchEntry(R.string.dictate__system_prompt_title, S_REWORDING, Routes.Settings.DictateRewording))

        // ---- Floating button ------------------------------------------------------------------------
        add(SettingsSearchEntry(R.string.dictate__floating_button_title, S_FLOATING, Routes.Settings.DictateFloatingButton))
        add(SettingsSearchEntry(R.string.dictate__floating_button_enable_title, S_FLOATING, Routes.Settings.DictateFloatingButton, anchor = "dictate__floating_button_enable_title"))
        add(SettingsSearchEntry(R.string.dictate__floating_button_size_title, S_FLOATING, Routes.Settings.DictateFloatingButton, anchor = "dictate__floating_button_size_title"))
        add(SettingsSearchEntry(R.string.dictate__floating_button_color_title, S_FLOATING, Routes.Settings.DictateFloatingButton, anchor = "dictate__floating_button_color_title"))

        // ---- Typing (suggestions & corrections) rows (anchored) ------------------------------------
        add(SettingsSearchEntry(R.string.pref__suggestion__enabled__label, S_TYPING, Routes.Settings.Typing, anchor = "pref__suggestion__enabled__label"))
        add(SettingsSearchEntry(R.string.pref__suggestion__incognito_mode__label, S_TYPING, Routes.Settings.Typing, anchor = "pref__suggestion__incognito_mode__label"))
        add(SettingsSearchEntry(R.string.pref__correction__auto_capitalization__label, S_TYPING, Routes.Settings.Typing, anchor = "pref__correction__auto_capitalization__label"))
        add(SettingsSearchEntry(R.string.pref__correction__double_space_period__label, S_TYPING, Routes.Settings.Typing, anchor = "pref__correction__double_space_period__label"))

        // ---- Gestures rows (anchored) --------------------------------------------------------------
        add(SettingsSearchEntry(R.string.pref__glide__enabled__label, S_GESTURES, Routes.Settings.Gestures, anchor = "pref__glide__enabled__label"))
        add(SettingsSearchEntry(R.string.pref__gestures__swipe_up__label, S_GESTURES, Routes.Settings.Gestures, anchor = "pref__gestures__swipe_up__label"))
        add(SettingsSearchEntry(R.string.pref__gestures__space_bar_long_press__label, S_GESTURES, Routes.Settings.Gestures, anchor = "pref__gestures__space_bar_long_press__label"))
        add(SettingsSearchEntry(R.string.pref__gestures__delete_key_swipe_left__label, S_GESTURES, Routes.Settings.Gestures, anchor = "pref__gestures__delete_key_swipe_left__label"))

        // ---- Clipboard rows (anchored) -------------------------------------------------------------
        add(SettingsSearchEntry(R.string.pref__clipboard__enable_clipboard_history__label, S_CLIPBOARD, Routes.Settings.Clipboard, anchor = "pref__clipboard__enable_clipboard_history__label"))
        add(SettingsSearchEntry(R.string.pref__clipboard__use_internal_clipboard__label, S_CLIPBOARD, Routes.Settings.Clipboard, anchor = "pref__clipboard__use_internal_clipboard__label"))
        add(SettingsSearchEntry(R.string.pref__clipboard__auto_clean_sensitive__label, S_CLIPBOARD, Routes.Settings.Clipboard, anchor = "pref__clipboard__auto_clean_sensitive__label"))

        // ---- Other / appearance --------------------------------------------------------------------
        add(SettingsSearchEntry(R.string.pref__other__settings_theme__label, S_OTHER, Routes.Settings.Other, anchor = "pref__other__settings_theme__label"))
        add(SettingsSearchEntry(R.string.pref__other__settings_accent_color__label, S_OTHER, Routes.Settings.Other, anchor = "pref__other__settings_accent_color__label"))
        add(SettingsSearchEntry(R.string.pref__other__settings_language__label, S_OTHER, Routes.Settings.Other, anchor = "pref__other__settings_language__label"))
    }
}
