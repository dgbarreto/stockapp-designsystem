# stockapp-designsystem

Módulo KMP (Kotlin Multiplatform) + Compose Multiplatform com o tema, tokens e componentes de UI compartilhados do [StockApp](https://github.com/dgbarreto/stockapp-app) — app de acompanhamento de investimentos (projeto de estudo).

Sem lógica de negócio: só design system (cores, tipografia, espaçamento, componentes base como botão/card/badge).

## Estrutura

- `designsystem/` — único módulo do repo, alvo Android (via `com.android.kotlin.multiplatform.library`) + iOS (framework estático `DesignSystem`), código comum em `designsystem/src/commonMain`.

## Status

**Fase 1 — Fundação** (ver roadmap no documento de planejamento do projeto): scaffold criado via [KMP Wizard](https://kmp.jetbrains.com/) da JetBrains, ainda sem tema/tokens implementados.

## Stack

- Kotlin 2.4.0 · Compose Multiplatform 1.11.1 · AGP 9.0.1

## Rodando

```
./gradlew :designsystem:build
./gradlew :designsystem:testAndroidHostTest
./gradlew :designsystem:iosSimulatorArm64Test
```

---

_Progresso mantido manualmente conforme o projeto avança._
