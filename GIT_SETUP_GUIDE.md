# Git Repository Setup Guide

Your Spring Boot Interview Assignment application is ready to be shared on GitHub!

## Step 1: Create a GitHub Repository

1. **Go to GitHub**: https://github.com/new
2. **Create a new repository**:
   - Repository name: `springboot-interview-assignment` (or any name you prefer)
   - Description: `Spring Boot application with H2 database demonstrating scalable architecture`
   - Choose: **Public** (so you can share the public URL with your interviewer)
   - Click **Create repository**

3. **Copy the repository URL** (you'll need it in the next steps)
   - It will look like: `https://github.com/your-username/springboot-interview-assignment.git`

## Step 2: Initialize Local Git Repository

```bash
# Navigate to your project directory
cd C:\Users\vatsalb\IdeaProjects\SpringBoot_Interview_Assignment

# Initialize git
git init

# Set your git configuration (do this once)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: Student Management API with scalable architecture"
```

## Step 3: Add Remote Repository and Push

```bash
# Add the remote repository (replace with your actual URL)
git remote add origin https://github.com/your-username/springboot-interview-assignment.git

# Rename branch to main (if needed)
git branch -M main

# Push to GitHub
git push -u origin main
```

## Step 4: Verify Your Repository

1. Go to your GitHub repository URL
2. Verify that all files are visible:
   - pom.xml
   - src/ directory with all Java files
   - README.md
   - QUICKSTART.md
   - .gitignore

## Common Issues & Solutions

### Issue: "Not a git repository"
**Solution**: Make sure you're in the correct directory:
```bash
cd C:\Users\vatsalb\IdeaProjects\SpringBoot_Interview_Assignment
```

### Issue: "Permission denied" or "Authentication failed"
**Solution**: Use GitHub token authentication:
1. Go to GitHub Settings → Developer settings → Personal access tokens
2. Create a new token with 'repo' scope
3. Use as password when prompted

Or set up SSH keys:
1. Generate SSH key: `ssh-keygen -t ed25519 -C "your.email@example.com"`
2. Add to GitHub: Settings → SSH and GPG keys
3. Use SSH URL: `git@github.com:your-username/springboot-interview-assignment.git`

### Issue: "fatal: remote origin already exists"
**Solution**: Remove existing remote first:
```bash
git remote remove origin
git remote add origin https://github.com/your-username/springboot-interview-assignment.git
```

## After Pushing to GitHub

### Share with Your Interviewer

1. **Public Repository URL**: `https://github.com/your-username/springboot-interview-assignment`
2. **Clone Command** (they can use to test):
   ```bash
   git clone https://github.com/your-username/springboot-interview-assignment.git
   cd springboot-interview-assignment
   mvn clean install
   mvn spring-boot:run
   ```

### Optional: Create a Release

For a more professional presentation:

```bash
# Create a tag
git tag -a v1.0.0 -m "Version 1.0.0 - Interview Assignment"

# Push tags to GitHub
git push origin v1.0.0
```

Then on GitHub, go to Releases and create a release from the tag.

## Making Future Updates

After you push the initial version:

```bash
# Make changes to your code
# ... edit files ...

# Stage changes
git add .

# Commit changes
git commit -m "Add feature description"

# Push to GitHub
git push origin main
```

## Useful Git Commands

```bash
# Check git status
git status

# View commit history
git log --oneline

# Create a new branch (for organizing features)
git checkout -b feature/new-feature

# Switch to main branch
git checkout main

# Merge a branch
git merge feature/new-feature

# Delete a branch
git branch -d feature/new-feature
```

## Interview Tips

When presenting the GitHub link to your interviewer:

1. **Prepare a brief explanation**: "I created a Spring Boot application with a scalable, layered architecture..."
2. **Be ready to discuss**:
   - The folder structure and why it's organized that way
   - The separation of concerns (Controller → Service → Repository)
   - How it handles errors globally
   - Why H2 in-memory database was chosen
   - How new features can be added without breaking existing code
3. **Be prepared to show**:
   - Running the application locally
   - Testing the API endpoint
   - Viewing the H2 console
   - Walking through the code structure

## Maintenance

### Update Dependencies (if needed)
```bash
mvn versions:display-dependency-updates
```

### Format Code
```bash
mvn spotless:apply
```

### Run Tests (once you add tests)
```bash
mvn test
```

---

## Quick Reference: Git Setup Commands

```bash
# Complete workflow
cd C:\Users\vatsalb\IdeaProjects\SpringBoot_Interview_Assignment
git init
git config --global user.name "Your Name"
git config --global user.email "your@email.com"
git add .
git commit -m "Initial commit: Student Management API"
git remote add origin https://github.com/YOUR-USERNAME/springboot-interview-assignment.git
git branch -M main
git push -u origin main
```

**That's it! Your project is now on GitHub and ready to share! 🚀**

