import express from "express";
import fetch from "node-fetch";

const app = express();
const PORT = process.env.PORT || 3000;
const API_URL = process.env.API_URL || "http://localhost:8080";

app.get("/", async (req, res) => {
    try {
        const r = await fetch(`${API_URL}/api/metrics`);
        const data = await r.json();
        res.send(`
      <html>
        <head><title>Carbon Dashboard</title></head>
        <body>
          <h1>Carbon Footprint Dashboard</h1>
          <p>Site: ${data.site}</p>
          <p>Page Size (KB): ${data.pageSizeKB}</p>
          <p>Load Time (ms): ${data.loadTimeMs}</p>
          <p>Estimated CO₂ (g): ${data.estimatedCO2g}</p>
          <p>Status: ${data.status === "PASS" ? "✅ PASS" : "❌ FAIL"}</p>
        </body>
      </html>
    `);
    } catch (e) {
        res.status(500).send(`Error fetching metrics: ${e}`);
    }
});

app.listen(PORT, () => console.log(`Web running at http://localhost:${PORT}`));