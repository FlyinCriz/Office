# Office

## Fristenrechner

`fristenrechner/index.html` – eigenständige Seite (einfach im Browser öffnen), die Fristen nach §§ 187 ff. BGB berechnet:

- Ereignis- und Beginnfrist (§ 187 Abs. 1, 2 BGB), Tage/Wochen/Monate/Jahre inkl. Monatsende-Regel (§ 188 Abs. 3 BGB)
- Verschiebung auf den nächsten Werktag (§ 193 BGB, § 31 Abs. 3 VwVfG, § 57 Abs. 2 VwGO i.V.m. § 222 Abs. 2 ZPO, § 64 Abs. 3 SGG, § 108 Abs. 3 AO, § 43 Abs. 2 StPO)
- Bekanntgabe- und Zustellungsfiktion (Vier-Tage-Regel seit 1.1.2025, § 41 Abs. 2 VwVfG, § 4 Abs. 2 VwZG, § 122 Abs. 2 AO, § 37 Abs. 2 SGB X)
- gesetzliche Feiertage aller 16 Bundesländer (Standard: Niedersachsen)
- Vorlagen für typische Prüfungsfristen (Widerspruch, Klage, Wiedereinsetzung, Rücknahme, Wiederaufgreifen, Bußgeldeinspruch u. a.)
- Prüfung der Fristwahrung und Klausurformulierung im Gutachtenstil

Lernhilfe zur Prüfungsvorbereitung, keine Rechtsberatung.

## Android-App

`android/` enthält eine schlanke Android-App (WebView), die `fristenrechner/` offline aus den App-Assets lädt – ohne Internet-Berechtigung. Web-Seite und App nutzen dieselbe `index.html`.

Bauen (JDK 17+, Android SDK mit Plattform 35):

```bash
cd android
./gradlew assembleRelease
# APK: app/build/outputs/apk/release/app-release.apk
```

Ohne `android/keystore.properties` (storeFile, storePassword, keyAlias, keyPassword) wird mit dem Debug-Schlüssel signiert. Die Schrift Figtree liegt unter der SIL Open Font License bei (`fristenrechner/fonts/OFL.txt`).
