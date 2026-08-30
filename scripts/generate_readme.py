import os
import re
import urllib.request
import json

SOLUTIONS_DIR = "my-solutions"
README_FILE = "README.md"

def get_topics(title_slug):
    query = """
    query getQuestionDetail($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        topicTags {
          name
        }
      }
    }
    """
    url = "https://leetcode.com/graphql"
    req = urllib.request.Request(
        url,
        data=json.dumps({"query": query, "variables": {"titleSlug": title_slug}}).encode("utf-8"),
        headers={"Content-Type": "application/json", "User-Agent": "Mozilla/5.0"}
    )
    try:
        with urllib.request.urlopen(req) as resp:
            data = json.loads(resp.read().decode("utf-8"))
            tags = data.get("data", {}).get("question", {}).get("topicTags", [])
            return [t["name"] for t in tags]
    except Exception:
        return ["Uncategorized"]

def main():
    if not os.path.exists(SOLUTIONS_DIR):
        print("Solutions folder not found.")
        return

    topic_map = {}
    problems = sorted(os.listdir(SOLUTIONS_DIR))

    for prob in problems:
        prob_path = os.path.join(SOLUTIONS_DIR, prob)
        if not os.path.isdir(prob_path):
            continue

        # Extract title slug from folder name (e.g., "0001-two-sum" -> "two-sum")
        match = re.match(r"^\d+-(.+)$", prob)
        title_slug = match.group(1) if match else prob
        title_display = title_slug.replace("-", " ").title()

        topics = get_topics(title_slug)
        if not topics:
            topics = ["Uncategorized"]

        for topic in topics:
            if topic not in topic_map:
                topic_map[topic] = []
            topic_map[topic].append((title_display, prob_path.replace("\\", "/")))

    # Generate Markdown
    content = "# 🧠 LeetCode Solutions & Topic Distribution\n\n"
    content += f"**Total Problems Solved:** {len(problems)}\n\n"
    content += "## 📚 Topics\n\n"

    for topic in sorted(topic_map.keys()):
        content += f"### {topic} ({len(topic_map[topic])})\n"
        for title, path in topic_map[topic]:
            content += f"- [{title}]({path})\n"
        content += "\n"

    with open(README_FILE, "w", encoding="utf-8") as f:
        f.write(content)
    print("README.md updated with topic breakdown.")

if __name__ == "__main__":
    main()
