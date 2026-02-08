# MoodSync: Intelligent Music Curation Engine

## Overview
MoodSync is a Java-based backend application designed to interface with the Spotify Web API. It provides users with deep insights into their listening habits and offers automated tools to curate and export logic-driven playlists. The project demonstrates the application of functional programming patterns, RESTful API integration, and OAuth 2.0 security protocols.

---

## Key Features

### 1. Listening Analytics Dashboard
Provides a comprehensive overview of user performance metrics. This feature retrieves and processes top artists, tracks, and genres across short-term (4 weeks), medium-term (6 months), and long-term (years) timeframes.

### 2. Algorithmic Smart Shuffle
A custom data processing engine that utilizes Java Streams to analyze a user's library. It filters tracks based on high-level audio features provided by Spotify, such as:
* Energy: Intensity and activity level of a track.
* Danceability: Suitability for dancing based on tempo and rhythm stability.
* Valence: The musical positiveness (mood) conveyed by a track.

### 3. Automated Playlist Exporter
A functional write-access tool that bridges the gap between analysis and action. Once the Smart Shuffle engine identifies a target list of tracks, the application performs multi-step API mutations to:
* Verify user authorization scopes.
* Initialize a new playlist container on the user's Spotify account.
* Batch-upload track URIs to the newly created playlist.

---

## Technical Stack
* Language: Java 21 (LTS)
* Framework: Spring Boot 3.x
* API Integration: Spotify Web API Java (se.michaelthelin.spotify)
* Security: OAuth 2.0 Authorization Code Flow
* Build Tool: Maven

---

## System Architecture
The application follows a clean, n-tier architecture to ensure separation of concerns and maintainability:

* Controller Layer: Orchestrates HTTP requests and manages the OAuth2 authentication handshake.
* Service Layer: Contains the core business logic, including Stream-based filtering and audio feature analysis.
* Client Layer: Manages external communication with Spotify’s REST endpoints using asynchronous execution.

---

## Development Roadmap
* Data Persistence: Integration of a PostgreSQL database to store historical snapshots of user statistics.
* Frontend Integration: Connection to a React-based dashboard for data visualization.
* Automated Testing: Implementation of JUnit 5 and Mockito for robust service-layer validation.
