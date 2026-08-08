# ArachneFlux

An early-stage Java web crawler prototype built on [jsoup](https://jsoup.org/).
It fetches a page, extracts and normalizes outbound links, and includes
groundwork for hashing, deduplicating, and compressing crawled pages for
later storage.

## Current state

This is a small, early prototype — not a production crawler yet. What's
implemented today (see `src/main/java/com/itswael/`):

- `Consumer.java` — fetches a hardcoded target (currently Wikipedia's front
  page), extracts headline links, normalizes them, and de-duplicates them
  in a `HashSet` before printing them to stdout.
- `HtmlTools.java` — normalizes relative/absolute URLs and strips URL
  fragments (`#...`).
- `Domain.java` / `DomainUrl.java` — value objects pairing a URL with a
  SHA-256 hash of itself (via `Hasher.java`), intended to key crawled
  pages/domains for storage or dedup.
- `HtmlPage.java` — wraps a fetched page's compressed HTML with its
  `DomainUrl` and fetch timestamp; its `save()` method is a stub — no
  persistence is implemented yet.
- `CompressionUtils.java` — Deflate/Inflate compression helpers for storing
  page content compactly (note: `Compress` currently returns the raw input
  bytes rather than the deflated output — the compression step doesn't take
  effect yet).
- `Producer.java` — an empty placeholder class, not yet implemented.

There is no persistence layer, queue/worker split, crawl frontier, or AI/ML
component yet — recursive crawling, storage, and the producer/consumer
split implied by the class names are still to be built.

## Tech stack

- Java, built with Maven (`pom.xml`)
- [jsoup](https://jsoup.org/) for HTML fetching and parsing

## Build & run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.itswael.Main"
```

`Main` currently runs `Consumer.start()`, which crawls the hardcoded URL in
`Consumer.java` and prints the discovered links.

## License

MIT — see [LICENSE](LICENSE).
