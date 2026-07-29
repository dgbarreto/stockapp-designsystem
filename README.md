# stockapp-designsystem

Kotlin Multiplatform (KMP) + Compose Multiplatform module with the shared theme, design tokens and UI components for [StockApp](https://github.com/dgbarreto/stockapp-app) — an investment tracking app (learning project).

No business logic here: just the design system (colors, typography, shapes, base components such as cards, buttons, text fields and avatars).

## Structure

- `designsystem/` — the only module in this repo, targeting Android (via `com.android.kotlin.multiplatform.library`) + iOS (static framework `DesignSystem`), shared code in `designsystem/src/commonMain`.
- `sample/` + `sample-android/` — dev-only sample apps (Android + Desktop) used to validate components in isolation.

## What's in it

- **Theme** (`theme/`): `StockAppColors`, `StockAppTypography`, `StockAppShapes` and `StockAppTheme` (a `MaterialTheme` derived from those tokens — every module renders through it, including plain Material3 components).
- **Components** (`components/`): `StockAppCard`, `StockAppKeyValueRow`, `StockAppErrorBanner`, `StockAppTextField`, `StockAppPrimaryButton` and `StockAppAvatar` (image loading via Coil 3, with initials fallback).

## Status

Fully implemented and published to GitHub Packages. Consumed by every other StockApp module (`stockapp-quotes`, `stockapp-auth`, `stockapp-portfolio`, `stockapp-orders`, `stockapp-app`).

## Stack

- Kotlin 2.4.0 · Compose Multiplatform 1.11.1 · AGP 9.0.1 · Coil 3

## Running

```
./gradlew :designsystem:build
./gradlew :designsystem:testAndroidHostTest
./gradlew :designsystem:iosSimulatorArm64Test
```

---

_Progress kept up to date manually as the project moves forward._
